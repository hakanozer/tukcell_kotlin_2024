package com.tlh.vize2

import java.io.Serializable



data class Plant(
    val common: String,
    val botanical: String,
    val zone: Int,
    val light: String,
    val price: String,
    val availability: String
): Serializable