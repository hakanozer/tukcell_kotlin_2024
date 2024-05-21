package com.toren.vize3.data.dto

import java.io.Serializable

data class Crypto(
    val coin: String,
    val network: String,
    val wallet: String
) : Serializable