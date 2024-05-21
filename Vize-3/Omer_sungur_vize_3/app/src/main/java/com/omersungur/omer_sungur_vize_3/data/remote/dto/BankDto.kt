package com.omersungur.omer_sungur_vize_3.data.remote.dto

data class BankDto(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
)
