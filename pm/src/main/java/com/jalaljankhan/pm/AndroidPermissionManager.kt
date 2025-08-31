package com.jalaljankhan.pm

import android.os.Build
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity

class AndroidPermissionManager private constructor(
    private val mPermissionLauncher: ActivityResultLauncher<Array<String>>
) : PermissionManager {
    companion object {
        fun from(
            activity: AppCompatActivity,
            onPermissionResult: (permissionsStates: PermissionResult) -> Unit
        ): PermissionManager {
            val launcher =
                activity.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
                    val granted = result?.entries?.filter { it.value }
                        ?.map { PermissionMapper().toPermission(it.key) } ?: emptyList()

                    val denied = result?.entries?.filter { !it.value }
                        ?.map { PermissionMapper().toPermission(it.key) } ?: emptyList()

                    onPermissionResult.invoke(
                        PermissionResult(
                            grantedPermissions = granted,
                            deniedPermissions = denied
                        )
                    )
                }

            return AndroidPermissionManager(launcher)
        }

        fun from(
            fragment: FragmentActivity,
            onPermissionResult: (permissionsStates: PermissionResult) -> Unit
        ): PermissionManager {
            val launcher =
                fragment.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
                    val granted = result?.entries?.filter { it.value }
                        ?.map { PermissionMapper().toPermission(it.key) } ?: emptyList()

                    val denied = result?.entries?.filter { !it.value }
                        ?.map { PermissionMapper().toPermission(it.key) } ?: emptyList()

                    onPermissionResult.invoke(
                        PermissionResult(
                            grantedPermissions = granted,
                            deniedPermissions = denied
                        )
                    )
                }

            return AndroidPermissionManager(launcher)
        }
    }

    override fun request(
        vararg permissions: Permission
    ) {
        mPermissionLauncher.launch(toPermissionValues(permissions))
    }

    private fun isSupported(permission: Permission): Boolean {
        return Build.VERSION.SDK_INT >= permission.minSdk
    }

    private fun toPermissionValues(permissions: Array<out Permission>): Array<String> {
        return permissions.filter { isSupported(it) }.map { it.value }.toTypedArray()
    }

}