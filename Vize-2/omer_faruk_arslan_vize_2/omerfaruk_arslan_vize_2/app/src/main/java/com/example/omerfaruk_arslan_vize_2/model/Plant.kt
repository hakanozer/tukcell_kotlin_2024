package com.example.omerfaruk_arslan_vize_2.model

import java.io.Serializable


data class Plant(
    val Common: String,
    val Botanical: String,
    val Zone: String,
    val Light: String,
    val Price: String
) : Serializable
