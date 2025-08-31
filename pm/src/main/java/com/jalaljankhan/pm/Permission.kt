package com.jalaljankhan.pm


import android.Manifest
import android.annotation.SuppressLint
import android.os.Build

/**
 * Complete set of dangerous (runtime) permissions in Android.
 * Includes fallbacks for different API levels.
 */

@SuppressLint("InlinedApi")
sealed class Permission(val value: String, val minSdk: Int = Build.VERSION_CODES.M) {
    // -------- STORAGE / MEDIA --------
    object ReadImages : Permission(
        value = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            Manifest.permission.READ_MEDIA_IMAGES else Manifest.permission.READ_EXTERNAL_STORAGE
    )

    object ReadVideo : Permission(
        value = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            Manifest.permission.READ_MEDIA_VIDEO else Manifest.permission.READ_EXTERNAL_STORAGE
    )

    object ReadAudio : Permission(
        value = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            Manifest.permission.READ_MEDIA_AUDIO else Manifest.permission.READ_EXTERNAL_STORAGE
    )

    // Deprecated after API 29 but still required on older devices
    object WriteExternalStorage : Permission(
        value = Manifest.permission.WRITE_EXTERNAL_STORAGE,
        minSdk = Build.VERSION_CODES.M
    )

    // -------- CAMERA & MICROPHONE --------
    object Camera : Permission(value = Manifest.permission.CAMERA)
    object RecordAudio : Permission(value = Manifest.permission.RECORD_AUDIO)

    // -------- LOCATION --------
    object FineLocation : Permission(value = Manifest.permission.ACCESS_FINE_LOCATION)
    object CoarseLocation : Permission(value = Manifest.permission.ACCESS_COARSE_LOCATION)
    object BackgroundLocation : Permission(
        value = Manifest.permission.ACCESS_BACKGROUND_LOCATION,
        minSdk = Build.VERSION_CODES.Q
    )

    // -------- NOTIFICATIONS --------
    object PostNotifications : Permission(
        value = Manifest.permission.POST_NOTIFICATIONS,
        minSdk = Build.VERSION_CODES.TIRAMISU
    )

    // -------- CONTACTS --------
    object ReadContacts : Permission(value = Manifest.permission.READ_CONTACTS)
    object WriteContacts : Permission(value = Manifest.permission.WRITE_CONTACTS)
    object GetAccounts : Permission(value = Manifest.permission.GET_ACCOUNTS) // legacy

    // -------- PHONE --------
    object ReadPhoneState : Permission(value = Manifest.permission.READ_PHONE_STATE)
    object CallPhone : Permission(value = Manifest.permission.CALL_PHONE)
    object ReadCallLog : Permission(value = Manifest.permission.READ_CALL_LOG)
    object WriteCallLog : Permission(value = Manifest.permission.WRITE_CALL_LOG)

    object AnswerPhoneCalls : Permission(
        value = Manifest.permission.ANSWER_PHONE_CALLS,
        minSdk = Build.VERSION_CODES.O
    )
    object AcceptHandover : Permission(
        value = Manifest.permission.ACCEPT_HANDOVER,
        minSdk = Build.VERSION_CODES.P
    )

    // Rare / legacy
    object UseSip : Permission(value = Manifest.permission.USE_SIP) // VoIP
    object AddVoicemail : Permission(value = Manifest.permission.ADD_VOICEMAIL)
    object ProcessOutgoingCalls : Permission(value = Manifest.permission.PROCESS_OUTGOING_CALLS)

    // -------- SMS --------
    object SendSms : Permission(value = Manifest.permission.SEND_SMS)
    object ReceiveSms : Permission(value = Manifest.permission.RECEIVE_SMS)
    object ReadSms : Permission(value = Manifest.permission.READ_SMS)
    object ReceiveMms : Permission(value = Manifest.permission.RECEIVE_MMS)
    object ReceiveWapPush : Permission(value = Manifest.permission.RECEIVE_WAP_PUSH)

    // -------- SENSORS / ACTIVITY --------
    object BodySensors : Permission( value = Manifest.permission.BODY_SENSORS)

    object BodySensorsBackground : Permission(
        value = Manifest.permission.BODY_SENSORS_BACKGROUND,
        minSdk = Build.VERSION_CODES.TIRAMISU
    )

    object ActivityRecognition : Permission(
        value = Manifest.permission.ACTIVITY_RECOGNITION,
        minSdk = Build.VERSION_CODES.Q
    )

    // -------- BLUETOOTH / NEARBY --------
    object BluetoothScan : Permission(
        value = Manifest.permission.BLUETOOTH_SCAN,
        minSdk = Build.VERSION_CODES.S
    )

    object BluetoothConnect : Permission(
        value = Manifest.permission.BLUETOOTH_CONNECT,
        minSdk = Build.VERSION_CODES.S
    )

    object BluetoothAdvertise : Permission(
        value = Manifest.permission.BLUETOOTH_ADVERTISE,
        minSdk = Build.VERSION_CODES.S
    )

    object NearbyWifiDevices : Permission(
        value = Manifest.permission.NEARBY_WIFI_DEVICES,
        minSdk = Build.VERSION_CODES.TIRAMISU
    )
}