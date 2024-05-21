package com.example.eray_altilar_vize_3.domain.model

data class AddressModel(
    val address: String?,
    val city: String?,
    val coordinates: CoordinatesModel,
    val postalCode: String?,
    val state: String?
)