package com.tlh.vize3.models

data class UserResponse(val users: List<User>)
data class User(val id: Int, val firstName: String, val lastName: String, val age: Int, val bloodGroup: String)
