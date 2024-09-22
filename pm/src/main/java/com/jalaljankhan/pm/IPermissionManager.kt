package com.jalaljankhan.pm


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

interface IPermissionManager {
    fun initialize(context: AppCompatActivity)

    fun requestRuntimePermissions(
        context: AppCompatActivity,
        permissions: Array<String>
    )

    fun permissionsPermanentlyDenied(context: Activity, vararg permissions: String): Boolean

    fun permissionsGranted(context: Activity, vararg permissions: String): Boolean

    fun onPermitted(result: (granted: Boolean) -> Unit)
}