package com.muratdayan.vize3.models

data class UsersRespond(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)