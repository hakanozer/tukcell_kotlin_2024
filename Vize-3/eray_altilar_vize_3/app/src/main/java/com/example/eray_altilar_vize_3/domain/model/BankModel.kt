package com.example.eray_altilar_vize_3.domain.model

data class BankModel(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
)