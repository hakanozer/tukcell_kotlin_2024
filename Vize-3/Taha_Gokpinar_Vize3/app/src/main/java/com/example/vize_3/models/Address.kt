package com.example.vize_3.models

data class Address(
    val address: String,
    val city: String? = null,
    val coordinates: Coordinates,
    val postalCode: String,
    val state: String
)
