package com.jalaljankhan.pm

import android.os.Build

/**
 * Groups permissions into high-level categories.
 * Library users can request categories instead of individual permissions.
 */
sealed class PermissionCategory(val permissions: List<Permission>) {

    // -------- Storage / Media --------
    object Storage : PermissionCategory(
        listOf(
            Permission.ReadImages,
            Permission.ReadVideo,
            Permission.ReadAudio,
            Permission.WriteExternalStorage // legacy
        )
    )

    // -------- Camera & Microphone --------
    object Camera : PermissionCategory(listOf(Permission.Camera))
    object Microphone : PermissionCategory(listOf(Permission.RecordAudio))

    // -------- Location --------
    object Location : PermissionCategory(
        buildList {
            add(Permission.FineLocation)
            add(Permission.CoarseLocation)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                add(Permission.BackgroundLocation)
            }
        }
    )

    // -------- Notifications --------
    object Notifications : PermissionCategory(
        listOf(Permission.PostNotifications)
    )

    // -------- Contacts --------
    object Contacts : PermissionCategory(
        listOf(
            Permission.ReadContacts,
            Permission.WriteContacts,
            Permission.GetAccounts // legacy
        )
    )

    // -------- Phone --------
    object Phone : PermissionCategory(
        listOf(
            Permission.ReadPhoneState,
            Permission.CallPhone,
            Permission.ReadCallLog,
            Permission.WriteCallLog,
            Permission.AnswerPhoneCalls,
            Permission.AcceptHandover,
            Permission.UseSip,
            Permission.AddVoicemail,
            Permission.ProcessOutgoingCalls
        )
    )

    // -------- SMS --------
    object Sms : PermissionCategory(
        listOf(
            Permission.SendSms,
            Permission.ReceiveSms,
            Permission.ReadSms,
            Permission.ReceiveMms,
            Permission.ReceiveWapPush
        )
    )

    // -------- Body Sensors --------
    object BodySensors : PermissionCategory(
        listOf(
            Permission.BodySensors,
            Permission.BodySensorsBackground
        )
    )

    // -------- Activity Recognition --------
    object ActivityRecognitionSensor : PermissionCategory(
        listOf(Permission.ActivityRecognition)
    )

    // -------- Bluetooth --------
    object Bluetooth : PermissionCategory(
        listOf(
            Permission.BluetoothScan,
            Permission.BluetoothConnect,
            Permission.BluetoothAdvertise
        )
    )

    // -------- Nearby --------
    object NearByDevices : PermissionCategory(
        listOf(Permission.NearbyWifiDevices)
    )
}