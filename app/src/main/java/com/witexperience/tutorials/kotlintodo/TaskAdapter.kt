package com.witexperience.tutorials.kotlintodo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_task.view.*


class TaskAdapter(context: Context, tasks: MutableList<Task> = ArrayList()) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    var tasks: MutableList<Task> = tasks
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val completedtask = v.tag as Task
            removeTask(completedtask)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent?.context)?.inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder?, position: Int) {
        holder?.bindTask(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun addTask(task: Task) {
        tasks.add(task)
        notifyDataSetChanged()
    }

    fun removeTask(task: Task) {
        tasks.remove(task)
        notifyDataSetChanged()
    }


    inner class TaskViewHolder(view: View?) : RecyclerView.ViewHolder(view) {

        fun bindTask(task: Task) {
            itemView.task_description.text = task.description

            with (itemView){
            tag = task
            itemView.setOnClickListener(mOnClickListener)
        }
    }
    }
}