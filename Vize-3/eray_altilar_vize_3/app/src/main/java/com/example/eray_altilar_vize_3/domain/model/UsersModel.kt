package com.example.eray_altilar_vize_3.domain.model

import java.io.Serializable


data class UsersModel(
    val users: List<UserModel>,
    val limit: Int,
    val skip: Int,
    val total: Int,
) : Serializable