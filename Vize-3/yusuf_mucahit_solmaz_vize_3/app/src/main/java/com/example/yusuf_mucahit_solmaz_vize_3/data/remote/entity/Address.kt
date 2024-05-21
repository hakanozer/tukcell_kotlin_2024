package com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity

import java.io.Serializable

data class Address(
    val address: String,
    val city: String,
    val coordinates: Coordinates,
    val postalCode: String,
    val state: String
): Serializable