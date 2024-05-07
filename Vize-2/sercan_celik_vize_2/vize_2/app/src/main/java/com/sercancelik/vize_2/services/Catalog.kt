package com.sercancelik.vize_2.services

import java.io.Serializable

data class Catalog(
    val common: String,
    val botanical: String,
    val zone: String,
    val light: String,
    val price: String,
    val availability: String
) : Serializable