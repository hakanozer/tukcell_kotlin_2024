package com.omersungur.omer_sungur_vize_3.data.remote.dto

data class AddressDto(
    val address: String,
    val city: String,
    val coordinates: CoordinatesDto,
    val postalCode: String,
    val state: String
)