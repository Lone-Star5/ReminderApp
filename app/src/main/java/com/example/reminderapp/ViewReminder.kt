package com.example.reminderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.reminderapp.data.task
import com.example.reminderapp.data.taskdb

class ViewReminder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_reminder)
        System.out.println("chutiya1")
        val data = ArrayList<task>()
        val db = Room.databaseBuilder(
            applicationContext,
            taskdb::class.java, "task"
        ).allowMainThreadQueries().build()
        val taskdao = db.taskdao()
        val tasks: List<task> = taskdao.getAll()
        val adapter = adapter(tasks)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        tasks.forEach(System.out::print)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }
}
