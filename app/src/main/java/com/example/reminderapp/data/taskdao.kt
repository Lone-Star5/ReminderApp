package com.example.reminderapp.data
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import  androidx.room.Delete
@Dao
interface taskdao {
    @Insert
    fun insert(
        task : task
    )
    @Delete
    fun delete(
        task :  task
    )
    @Query("select * from reminder_data")
    fun getAll(): List<task>
}