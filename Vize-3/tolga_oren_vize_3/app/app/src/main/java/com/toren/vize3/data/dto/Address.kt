package com.toren.vize3.data.dto

import java.io.Serializable

data class Address(
    val address: String,
    val city: String,
    val coordinates: Coordinates,
    val postalCode: String,
    val state: String
) : Serializable