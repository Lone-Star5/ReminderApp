<<<<<<< HEAD
package com.example.reminderapp

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class CreateReminder : AppCompatActivity() {

    private lateinit var createReminderBtn : Button
    private lateinit var title : EditText
    private lateinit var description: EditText
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker

    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelId = "12345"
    private val channeldescription = "Notification Channel"

    @SuppressLint("RemoteViewLayout")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_reminder)

        createReminderBtn = findViewById(R.id.create_reminder_btn)
        title = findViewById(R.id.addTitle)
        description = findViewById(R.id.addDescription)
        datePicker = findViewById(R.id.addDate)
        timePicker = findViewById(R.id.addTime)
        timePicker.setOnTimeChangedListener { _, hour, minute -> var hour = hour
            var am_pm = ""
            // AM_PM decider logic
            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM"
                }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }
        }

//        var dateText = ""

        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))
        { view, year, month, day ->
            val month = month + 1
//            dateText = "$day/$month/$year"
        }

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createReminderBtn.setOnClickListener {
            val titleText = title.text
            val descriptionText = description.text

            val cal = Calendar.getInstance()


            val hr = timePicker.currentHour
            val min = timePicker.currentMinute
            val day = datePicker.dayOfMonth
            val month = datePicker.month
            val year = datePicker.year
            val msg = "$titleText | $descriptionText | $day : $month : $year | $hr : $min"
            Toast.makeText(this, "Reminder Created for $msg", Toast.LENGTH_LONG).show()

            val current = Calendar.getInstance()

            cal[Calendar.DAY_OF_MONTH] = day
            cal[Calendar.MONTH] = month
            cal[Calendar.YEAR] = year
            cal[Calendar.HOUR] = hr
            cal[Calendar.MINUTE] = min
            cal.set(Calendar.HOUR_OF_DAY, hr);
            cal.set(Calendar.SECOND, 0);
            val millis = cal.timeInMillis

            if(cal.compareTo(current) <= 0){
                //The set Date/Time already passed
                Toast.makeText(getApplicationContext(),
                    "Invalid Date/Time",
                    Toast.LENGTH_LONG).show();
            }else{
                setAlarm(cal);
            }



            val intent = Intent(this, LauncherActivity::class.java)

            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId, channeldescription, NotificationManager .IMPORTANCE_HIGH)
                notificationChannel.lightColor = Color.BLUE
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)
                builder = Notification.Builder(this, channelId)
                    .setContentTitle("$titleText")
                    .setContentText("$descriptionText")
                    .setSmallIcon(R.drawable.icon)
                    .setContentIntent(pendingIntent)
            }
            notificationManager.notify(12345, builder.build())
        }
    }

    private fun setAlarm(cal: Calendar) {
        val titleText = title.text

        val intent = Intent(baseContext, AlarmReceiver::class.java)
        System.out.println("titleText: $titleText")
        intent.putExtra("title", titleText.toString())
        val pendingIntent = PendingIntent.getBroadcast(baseContext, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager[AlarmManager.RTC_WAKEUP, cal.getTimeInMillis()] = pendingIntent
    }
=======
package com.example.reminderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.reminderapp.data.task
import com.example.reminderapp.data.taskdb

class CreateReminder : AppCompatActivity() {
    private lateinit var createReminderBtn : Button

    private lateinit var title : EditText
    private lateinit var description: EditText
    private lateinit var date: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_reminder)
        supportActionBar?.setTitle("create reminder")
        createReminderBtn = findViewById(R.id.create_reminder_btn)
        val db = Room.databaseBuilder(applicationContext, taskdb::class.java, "task").allowMainThreadQueries().build()
        val taskdao= db.taskdao()
            
        title = findViewById(R.id.addTitle)
        description = findViewById(R.id.addDescription)
        date = findViewById(R.id.addDate)

        var dateText = ""

        val today = Calendar.getInstance()
        date.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))
        { view, year, month, day ->
            val month = month + 1
            dateText = "$day/$month/$year"
        }

        createReminderBtn.setOnClickListener {
            val titleText = title.text
            val descriptionText = description.text

            val msg = "$titleText $descriptionText $dateText"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            val tempreminder = task(title.text.toString(),description.text.toString(),dateText.toString())
            taskdao.insert(tempreminder)
        }
    }
>>>>>>> c8386c31f2f63a729586182bb4e7e40f433b7714
}