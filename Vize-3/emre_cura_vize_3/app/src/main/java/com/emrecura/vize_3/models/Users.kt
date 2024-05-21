package com.emrecura.vize_3.models

import java.io.Serializable

data class Users(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
) : Serializable