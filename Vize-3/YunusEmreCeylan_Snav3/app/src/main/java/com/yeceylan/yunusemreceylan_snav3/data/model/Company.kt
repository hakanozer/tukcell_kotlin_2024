package com.yeceylan.yunusemreceylan_snav3.data.model

import java.io.Serializable

data class Company(
    val address: Address,
    val department: String,
    val name: String,
    val title: String
): Serializable