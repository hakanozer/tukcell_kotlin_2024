package com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity

import java.io.Serializable

data class Crypto(
    val coin: String,
    val network: String,
    val wallet: String
): Serializable