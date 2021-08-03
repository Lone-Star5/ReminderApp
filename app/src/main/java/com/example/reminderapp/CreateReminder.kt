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
    private lateinit var addtitle: EditText
    private lateinit var adddescription: EditText
    private lateinit var adddate: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_reminder)
        supportActionBar?.setTitle("create reminder")
        createReminderBtn = findViewById(R.id.create_reminder_btn)
        addtitle=findViewById(R.id.addtitle)
        adddate=findViewById(R.id.addDate)
        adddescription=findViewById(R.id.adddescription)
        val db = Room.databaseBuilder(applicationContext, taskdb::class.java, "task").allowMainThreadQueries().build()
        val taskdao= db.taskdao()
        createReminderBtn.setOnClickListener {
            val tempreminder = task(addtitle.text.toString(),adddescription.text.toString(),adddate.text.toString())
            taskdao.insert(tempreminder)
            Toast.makeText(this, "Feature Under Development", Toast.LENGTH_SHORT).show()
        }
    }
}