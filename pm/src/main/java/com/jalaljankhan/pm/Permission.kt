package com.jalaljankhan.pm


import android.annotation.SuppressLint
import android.os.Build

@SuppressLint("InlinedApi")
sealed class Permission(val value: String, val minimumSdk: Int = Build.VERSION_CODES.M) {
    object Camera : Permission(value = android.Manifest.permission.CAMERA)
    object RecordAudio : Permission(value = android.Manifest.permission.RECORD_AUDIO)
    object ReadContacts : Permission(value = android.Manifest.permission.READ_CONTACTS)
    object WriteContacts : Permission(value = android.Manifest.permission.WRITE_CONTACTS)
    object GetAccounts : Permission(value = android.Manifest.permission.GET_ACCOUNTS)
    object FineLocation : Permission(value = android.Manifest.permission.ACCESS_FINE_LOCATION)
    object CoarseLocation : Permission(value = android.Manifest.permission.ACCESS_COARSE_LOCATION)

    object BackgroundLocation : Permission(
        value = android.Manifest.permission.ACCESS_BACKGROUND_LOCATION,
        minimumSdk = Build.VERSION_CODES.Q
    )

    object ReadPhoneState : Permission(value = android.Manifest.permission.READ_PHONE_STATE)
    object CallPhone : Permission(value = android.Manifest.permission.CALL_PHONE)
    object ReadCallLog : Permission(value = android.Manifest.permission.READ_CALL_LOG)
    object WriteCallLog : Permission(value = android.Manifest.permission.WRITE_CALL_LOG)

    object AnswerPhoneCalls : Permission(
        value = android.Manifest.permission.ANSWER_PHONE_CALLS,
        minimumSdk = Build.VERSION_CODES.O
    )

    object AcceptHandOver : Permission(
        value = android.Manifest.permission.ACCEPT_HANDOVER,
        minimumSdk = Build.VERSION_CODES.P
    )

    object SendSMS : Permission(value = android.Manifest.permission.SEND_SMS)
    object ReceiveSMS : Permission(value = android.Manifest.permission.RECEIVE_SMS)
    object ReadSMS : Permission(value = android.Manifest.permission.READ_SMS)
    object ReceiveMMS : Permission(value = android.Manifest.permission.RECEIVE_MMS)
    object ReadExternalStorage :
        Permission(value = android.Manifest.permission.READ_EXTERNAL_STORAGE)

    object WriteExternalStorage :
        Permission(value = android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    object ReadMediaImage : Permission(
        value = android.Manifest.permission.READ_MEDIA_IMAGES,
        minimumSdk = Build.VERSION_CODES.TIRAMISU
    )

    object ReadMediaVideo : Permission(
        value = android.Manifest.permission.READ_MEDIA_VIDEO,
        minimumSdk = Build.VERSION_CODES.TIRAMISU
    )

    object ReadMediaAudio : Permission(
        value = android.Manifest.permission.READ_MEDIA_AUDIO,
        minimumSdk = Build.VERSION_CODES.TIRAMISU
    )

    object BodySensor : Permission(value = android.Manifest.permission.BODY_SENSORS)
    object BodySensorBackground : Permission(
        value = android.Manifest.permission.BODY_SENSORS_BACKGROUND,
        minimumSdk = Build.VERSION_CODES.TIRAMISU
    )

    object ActivityRecognition : Permission(
        value = android.Manifest.permission.ACTIVITY_RECOGNITION,
        minimumSdk = Build.VERSION_CODES.Q
    )

    object BluetoothScan : Permission(
        value = android.Manifest.permission.BLUETOOTH_SCAN,
        minimumSdk = Build.VERSION_CODES.S
    )

    object BluetoothConnect : Permission(
        value = android.Manifest.permission.BLUETOOTH_CONNECT,
        minimumSdk = Build.VERSION_CODES.S
    )

    object BluetoothAdvertise : Permission(
        value = android.Manifest.permission.BLUETOOTH_ADVERTISE,
        minimumSdk = Build.VERSION_CODES.S
    )

    object NearbyWifiDevices : Permission(
        value = android.Manifest.permission.NEARBY_WIFI_DEVICES,
        minimumSdk = Build.VERSION_CODES.TIRAMISU
    )
}