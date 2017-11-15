package com.witexperience.tutorials.kotlintodo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        //Set the button r.id.submit to respond to clicks by adding the text that we have input to our list of tasks.
        //If the field is empty, it will prompt us to enter text and try again.
        submit?.setOnClickListener {
            if (task_description?.text?.toString().isNullOrBlank()) {
                task_description?.error = "Please enter a description"
            } else {
                val data = Intent()
                data.putExtra(MainActivity.DESCRIPTION_TEXT, task_description?.text.toString())
                setResult(Activity.RESULT_OK, data)
                finish()
            }
        }

    }
}
