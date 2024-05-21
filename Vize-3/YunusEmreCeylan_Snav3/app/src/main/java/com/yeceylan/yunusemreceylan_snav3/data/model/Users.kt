package com.yeceylan.yunusemreceylan_snav3.data.model

import java.io.Serializable

data class Users(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
): Serializable