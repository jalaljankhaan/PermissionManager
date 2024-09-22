package com.jalaljankhan.azpermissionmanager

import android.app.Activity
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat.checkSelfPermission

class PermissionManager : IPermissionManager {
    private var mPermissionsResult: ((granted: Boolean) -> Unit)? = null
    private lateinit var mPermissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onPermitted(result: (granted: Boolean) -> Unit) {
        mPermissionsResult = result
    }

    override fun initialize(context: AppCompatActivity) {
        mPermissionLauncher = context.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            result.entries.forEach {
                println("${it.key} = ${it.value}")
            }

            mPermissionsResult?.invoke(result.values.all { it })
        }
    }

    //    private var mPermissionLauncher: ActivityResultLauncher<>
    override fun requestRuntimePermissions(
        context: AppCompatActivity,
        permissions: Array<String>
    ) {
        mPermissionLauncher.launch(permissions)
    }

    override fun permissionsPermanentlyDenied(
        context: Activity,
        vararg permissions: String
    ): Boolean {
        return permissions.all { permission ->
            checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_DENIED && !shouldShowRequestPermissionRationale(
                context,
                permission
            )
        }
    }

    override fun permissionsGranted(context: Activity, vararg permissions: String): Boolean {
        return permissions.all {
            checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }
    }
}