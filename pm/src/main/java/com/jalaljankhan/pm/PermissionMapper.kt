package com.jalaljankhan.pm

class PermissionMapper {
    fun toPermission(value: String): Permission {
        return when (value) {
            Permission.Camera.value -> Permission.Camera
            Permission.ReadImages.value -> Permission.ReadImages
            Permission.ReadVideo.value -> Permission.ReadVideo
            Permission.ReadAudio.value -> Permission.ReadAudio
            Permission.WriteExternalStorage.value -> Permission.WriteExternalStorage
            Permission.RecordAudio.value -> Permission.RecordAudio
            Permission.FineLocation.value -> Permission.FineLocation
            Permission.CoarseLocation.value -> Permission.CoarseLocation
            Permission.BackgroundLocation.value -> Permission.BackgroundLocation
            Permission.PostNotifications.value -> Permission.PostNotifications
            Permission.ReadContacts.value -> Permission.ReadContacts
            Permission.WriteContacts.value -> Permission.WriteContacts
            Permission.ReadPhoneState.value -> Permission.ReadPhoneState
            Permission.CallPhone.value -> Permission.CallPhone
            Permission.ReadCallLog.value -> Permission.ReadCallLog
            Permission.WriteCallLog.value -> Permission.WriteCallLog
            Permission.AnswerPhoneCalls.value -> Permission.AnswerPhoneCalls
            Permission.AcceptHandover.value -> Permission.AcceptHandover
            Permission.UseSip.value -> Permission.UseSip
            Permission.AddVoicemail.value -> Permission.AddVoicemail
            Permission.ProcessOutgoingCalls.value -> Permission.ProcessOutgoingCalls
            Permission.SendSms.value -> Permission.SendSms
            Permission.ReceiveSms.value -> Permission.ReceiveSms
            Permission.ReadSms.value -> Permission.ReadSms
            Permission.ReceiveMms.value -> Permission.ReceiveMms
            Permission.ReceiveWapPush.value -> Permission.ReceiveWapPush
            Permission.BodySensors.value -> Permission.BodySensors
            Permission.BodySensorsBackground.value -> Permission.BodySensorsBackground
            Permission.ActivityRecognition.value -> Permission.ActivityRecognition
            Permission.BluetoothScan.value -> Permission.BluetoothScan
            Permission.BluetoothConnect.value -> Permission.BluetoothConnect
            Permission.BluetoothAdvertise.value -> Permission.BluetoothAdvertise
            Permission.NearbyWifiDevices.value -> Permission.NearbyWifiDevices
            else -> throw IllegalArgumentException("Unknown permission: $value")
        }
    }
}