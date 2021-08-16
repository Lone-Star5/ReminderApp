package com.example.reminderapp

import android.R
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat


class SendNotification : IntentService("MyNewIntentService") {
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelId = "12345"
    private val channeldescription = "Notification Channel"

    override fun onHandleIntent(intent: Intent?) {
        val title = intent?.getStringExtra("title").toString()

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        Toast.makeText(getApplicationContext(),
            "msg : $title",
            Toast.LENGTH_LONG).show();

        val intent = Intent(this, LauncherActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId, channeldescription, NotificationManager .IMPORTANCE_HIGH)
            notificationChannel.lightColor = Color.BLUE
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
            builder = Notification.Builder(this, channelId)
                .setContentTitle("$title")
                .setContentText("this works")
                .setSmallIcon(com.example.reminderapp.R.drawable.icon)
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(12345, builder.build())
    }

}