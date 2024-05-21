package com.ns.enesarisoy_vize3.model

import java.io.Serializable

data class UserResponse(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
): Serializable