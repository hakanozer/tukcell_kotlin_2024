package com.sercancelik.vize_3_sercan_celik.models

data class UserResponse(
    val users: List<User>
)

data class User(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val age: Short,
    val image: String,
    val bloodGroup: String,
)


