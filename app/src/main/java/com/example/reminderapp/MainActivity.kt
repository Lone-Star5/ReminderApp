package com.example.reminderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var createReminder: Button
    private lateinit var viewReminder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createReminder = findViewById(R.id.reminder_create)
        viewReminder = findViewById(R.id.reminder_view)

        createReminder.setOnClickListener{
            val intent = Intent(this,CreateReminder::class.java)
            startActivity(intent)
        }

        viewReminder.setOnClickListener {
            Toast.makeText(this, "Feature Under Development", Toast.LENGTH_SHORT).show()
        }
    }
}