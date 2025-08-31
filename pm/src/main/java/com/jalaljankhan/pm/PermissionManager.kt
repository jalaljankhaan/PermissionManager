package com.jalaljankhan.pm


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

interface PermissionManager {
    fun initialize(context: AppCompatActivity)

    fun request(
        context: AppCompatActivity,
        permissions: Array<String>
    )

    fun permissionsPermanentlyDenied(context: Activity, vararg permissions: String): Boolean

    fun permissionsGranted(context: Activity, vararg permissions: String): Boolean

    fun onPermitted(result: (granted: Boolean) -> Unit)
}