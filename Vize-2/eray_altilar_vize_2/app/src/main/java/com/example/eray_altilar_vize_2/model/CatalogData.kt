package com.example.eray_altilar_vize_2.model

import java.io.Serializable

data class CatalogData(
    val common:String,
    val botanical: String,
    val zone: String,
    val light: String,
    val price: String,
    val availability: String
) : Serializable
