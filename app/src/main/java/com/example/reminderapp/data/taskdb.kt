package com.example.reminderapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(task::class),version = 1)
abstract class taskdb:RoomDatabase() {
    abstract fun taskdao(): taskdao
}