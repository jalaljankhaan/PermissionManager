package com.jalaljankhan.pm

data class PermissionResult(
    val grantedPermissions: Set<Permission>,
    val deniedPermissions: Set<Permission>,
) {
    val allGranted: Boolean
        get() = grantedPermissions.isNotEmpty()

    val allDenied: Boolean
        get() = deniedPermissions.isNotEmpty()
}