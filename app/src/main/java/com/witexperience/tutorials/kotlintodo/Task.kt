package com.witexperience.tutorials.kotlintodo

import java.io.Serializable

data class Task(
        var description: String,
        var completed: Boolean = false
) : Serializable

