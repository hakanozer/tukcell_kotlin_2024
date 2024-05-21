package com.omersungur.omer_sungur_vize_3.domain.model

import java.io.Serializable

data class User(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserX>
): Serializable
