package com.example.reminderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class CreateReminder : AppCompatActivity() {

    private lateinit var createReminderBtn : Button
    private lateinit var title : EditText
    private lateinit var description: EditText
    private lateinit var date: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_reminder)

        createReminderBtn = findViewById(R.id.create_reminder_btn)
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
        }
    }
}