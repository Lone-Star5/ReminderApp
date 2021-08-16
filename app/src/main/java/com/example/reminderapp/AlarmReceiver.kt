package com.example.reminderapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent


private const val TAG = "alarm"

class AlarmReceiver : BroadcastReceiver() {
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelId = "12345"
    private val channeldescription = "Notification Channel"

    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.getStringExtra("title").toString()

        val intent1 = Intent(context, SendNotification::class.java)
        System.out.println(" title: $title")
        intent1.putExtra("title", title);
        context.startService(intent1)
    }
}