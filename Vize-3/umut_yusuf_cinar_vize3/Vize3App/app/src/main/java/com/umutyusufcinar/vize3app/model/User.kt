package com.umutyusufcinar.vize3app.model

import java.io.Serializable

data class User(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserX>
): Serializable