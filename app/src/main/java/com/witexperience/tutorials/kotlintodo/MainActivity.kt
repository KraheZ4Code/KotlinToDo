package com.witexperience.tutorials.kotlintodo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val adapter = TaskAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        task_list.layoutManager = LinearLayoutManager(this)
        task_list.adapter = adapter
        fab.setOnClickListener { _ ->
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(intent, ADD_TASK_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_TASK_REQUEST && resultCode == Activity.RESULT_OK) {
            val task = Task(data?.getStringExtra(DESCRIPTION_TEXT).orEmpty())
            adapter.addTask(task)
        }

    }

    override fun onResume() {
        super.onResume()
        val tasks = Storage.readData(this)
        // We only want to set the tasks if the list is already empty.
        if (tasks != null && (adapter.tasks.isEmpty())) {
            adapter.tasks = tasks
        }
    }

    override fun onPause() {
        super.onPause()

        Storage.writeData(this, adapter.tasks)
    }


    companion object {
        private val ADD_TASK_REQUEST = 0
        val DESCRIPTION_TEXT = "description"
    }
}
