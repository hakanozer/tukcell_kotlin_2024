package com.example.eray_altilar_vize_3.data.remote.dto

data class Users(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)