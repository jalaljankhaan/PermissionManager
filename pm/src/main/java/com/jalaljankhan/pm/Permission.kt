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
    object Camera : Permission(Manifest.permission.CAMERA)
    object RecordAudio : Permission(Manifest.permission.RECORD_AUDIO)

    // -------- LOCATION --------
    object FineLocation : Permission(Manifest.permission.ACCESS_FINE_LOCATION)
    object CoarseLocation : Permission(Manifest.permission.ACCESS_COARSE_LOCATION)
    object BackgroundLocation : Permission(
        Manifest.permission.ACCESS_BACKGROUND_LOCATION,
        minSdk = Build.VERSION_CODES.Q
    )

    // -------- NOTIFICATIONS --------
    object PostNotifications : Permission(
        Manifest.permission.POST_NOTIFICATIONS,
        minSdk = Build.VERSION_CODES.TIRAMISU
    )

    // -------- CONTACTS --------
    object ReadContacts : Permission(Manifest.permission.READ_CONTACTS)
    object WriteContacts : Permission(Manifest.permission.WRITE_CONTACTS)
    object GetAccounts : Permission(Manifest.permission.GET_ACCOUNTS) // legacy

    // -------- PHONE --------
    object ReadPhoneState : Permission(Manifest.permission.READ_PHONE_STATE)
    object CallPhone : Permission(Manifest.permission.CALL_PHONE)
    object ReadCallLog : Permission(Manifest.permission.READ_CALL_LOG)
    object WriteCallLog : Permission(Manifest.permission.WRITE_CALL_LOG)

    object AnswerPhoneCalls : Permission(
        Manifest.permission.ANSWER_PHONE_CALLS,
        minSdk = Build.VERSION_CODES.O
    )
    object AcceptHandover : Permission(
        Manifest.permission.ACCEPT_HANDOVER,
        minSdk = Build.VERSION_CODES.P
    )

    // Rare / legacy
    object UseSip : Permission(Manifest.permission.USE_SIP) // VoIP
    object AddVoicemail : Permission(Manifest.permission.ADD_VOICEMAIL)
    object ProcessOutgoingCalls : Permission(Manifest.permission.PROCESS_OUTGOING_CALLS)

    // -------- SMS --------
    object SendSms : Permission(Manifest.permission.SEND_SMS)
    object ReceiveSms : Permission(Manifest.permission.RECEIVE_SMS)
    object ReadSms : Permission(Manifest.permission.READ_SMS)
    object ReceiveMms : Permission(Manifest.permission.RECEIVE_MMS)
    object ReceiveWapPush : Permission(Manifest.permission.RECEIVE_WAP_PUSH)

    // -------- SENSORS / ACTIVITY --------
    object BodySensors : Permission(Manifest.permission.BODY_SENSORS)
    object BodySensorsBackground : Permission(
        Manifest.permission.BODY_SENSORS_BACKGROUND,
        minSdk = Build.VERSION_CODES.TIRAMISU
    )
    object ActivityRecognition : Permission(
        Manifest.permission.ACTIVITY_RECOGNITION,
        minSdk = Build.VERSION_CODES.Q
    )

    // -------- BLUETOOTH / NEARBY --------
    object BluetoothScan : Permission(
        Manifest.permission.BLUETOOTH_SCAN,
        minSdk = Build.VERSION_CODES.S
    )
    object BluetoothConnect : Permission(
        Manifest.permission.BLUETOOTH_CONNECT,
        minSdk = Build.VERSION_CODES.S
    )
    object BluetoothAdvertise : Permission(
        Manifest.permission.BLUETOOTH_ADVERTISE,
        minSdk = Build.VERSION_CODES.S
    )
    object NearbyWifiDevices : Permission(
        Manifest.permission.NEARBY_WIFI_DEVICES,
        minSdk = Build.VERSION_CODES.TIRAMISU
    )
}