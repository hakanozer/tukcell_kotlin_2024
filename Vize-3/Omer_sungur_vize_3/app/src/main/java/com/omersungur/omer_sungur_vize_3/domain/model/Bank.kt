package com.omersungur.omer_sungur_vize_3.domain.model

import java.io.Serializable

data class Bank(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
): Serializable
