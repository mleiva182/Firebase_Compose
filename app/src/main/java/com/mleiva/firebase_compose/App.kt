package com.mleiva.firebase_compose

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

/***
 * Project: Firebase_Compose
 * From: com.mleiva.firebase_compose
 * Creted by: Marcelo Leiva on 12-08-2024 at 21:37
 ***/
class App: Application() {

    companion object {
        const val FCM_CHANNEL_ID = "FCM_CHANNEL_ID"
    }

    override fun onCreate() {
        super.onCreate()
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            val fcmChannel = NotificationChannel(FCM_CHANNEL_ID, "FCM_Channel", NotificationManager.IMPORTANCE_HIGH)
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(fcmChannel)
        }
    }

}