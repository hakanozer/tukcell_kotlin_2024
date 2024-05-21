package com.omersungur.omer_sungur_vize_3.domain.model

import java.io.Serializable

data class Address(
    val address: String?,
    val city: String?,
    val coordinates: Coordinates,
    val postalCode: String?,
    val state: String?
): Serializable
