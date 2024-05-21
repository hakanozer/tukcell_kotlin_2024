package com.beyzaparlak.beyza_parlak_vize_3.modell

import java.io.Serializable

data class Address(
    val address: String,
    val city: String,
    val coordinates: Coordinates,
    val postalCode: String,
    val state: String
): Serializable
