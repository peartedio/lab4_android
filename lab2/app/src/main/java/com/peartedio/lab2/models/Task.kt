package com.peartedio.lab2.models

import org.joda.time.DateTime

data class Task(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val completed: Boolean = false,
    val deadline: DateTime? = null,
)
