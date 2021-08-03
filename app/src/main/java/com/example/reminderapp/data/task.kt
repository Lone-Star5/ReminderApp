package com.example.reminderapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.sql.Timestamp
import java.text.DateFormat

@Entity(tableName="reminder_data")
data class task (
    @PrimaryKey val title : String,
    val description: String?,
    val date: String?
)