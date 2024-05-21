package com.example.melihcakmak_vize3.models
data class Users(
    val users: List<User>,
    val total: Long,
    val skip: Long,
    val limit: Long,
)

data class User(
    val id: Long,
    val firstName: String,
    val image: String,
    val age: Long,
    val bloodGroup: String

)