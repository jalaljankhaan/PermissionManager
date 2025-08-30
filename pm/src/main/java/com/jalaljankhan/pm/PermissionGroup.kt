package com.jalaljankhan.pm

sealed class PermissionGroup(val permissions: List<Permission>) {
    sealed class Camera : PermissionGroup(listOf(Permission.Camera, Permission.RecordAudio))
    sealed class Camera : PermissionGroup(listOf(Permission.Camera, Permission.RecordAudio))
}