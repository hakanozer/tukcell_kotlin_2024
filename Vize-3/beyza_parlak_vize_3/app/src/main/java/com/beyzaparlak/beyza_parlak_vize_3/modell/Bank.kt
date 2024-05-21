package com.beyzaparlak.beyza_parlak_vize_3.modell

import java.io.Serializable

data class Bank(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
): Serializable