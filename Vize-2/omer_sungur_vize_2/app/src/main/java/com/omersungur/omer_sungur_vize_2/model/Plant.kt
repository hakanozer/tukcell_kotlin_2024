package com.omersungur.omer_sungur_vize_2.model

import java.io.Serializable

data class Plant(
    val common: String,
    val botanical: String,
    val zone: String,
    val light: String,
    val price: String,
    val availability: String
): Serializable
