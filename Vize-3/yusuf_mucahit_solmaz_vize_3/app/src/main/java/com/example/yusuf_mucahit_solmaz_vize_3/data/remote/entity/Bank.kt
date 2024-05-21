package com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity

import java.io.Serializable

data class Bank(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
): Serializable