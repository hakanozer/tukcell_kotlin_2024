package com.toren.vize3.data.dto

data class UsersResponse(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)