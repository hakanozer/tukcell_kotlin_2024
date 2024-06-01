package com.example.homework10.models

data class Todo(
    val id:Int?=0,
    var task: String,
    val userId:Int,
    var completed: Boolean = false
)

