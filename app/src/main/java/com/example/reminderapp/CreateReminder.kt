package com.example.reminderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CreateReminder : AppCompatActivity() {

    private lateinit var createReminderBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_reminder)

        createReminderBtn = findViewById(R.id.create_reminder_btn)

        createReminderBtn.setOnClickListener {
            Toast.makeText(this, "Feature Under Development", Toast.LENGTH_SHORT).show()
        }
    }
}