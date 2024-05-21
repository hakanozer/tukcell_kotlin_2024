package com.example.vize_3.models

data class Users(
    val users: List<User>,
    val total: Long,
    val skip: Long,
    val limit: Long
)