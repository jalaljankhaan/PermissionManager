package com.jalaljankhan.pm


interface PermissionManager {
    fun request(
        vararg permissions: Permission
    )
}