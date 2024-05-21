package com.yeceylan.yunusemreceylan_snav3.data.model

import java.io.Serializable

data class Bank(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
): Serializable