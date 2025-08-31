package com.jalaljankhan.pm

data class PermissionResult(
    val grantedPermissions: List<Permission>?,
    val deniedPermissions: List<Permission>?,
) {
    val allGranted: Boolean
        get() = !grantedPermissions.isNullOrEmpty()

    val allDenied: Boolean
        get() = !deniedPermissions.isNullOrEmpty()
}