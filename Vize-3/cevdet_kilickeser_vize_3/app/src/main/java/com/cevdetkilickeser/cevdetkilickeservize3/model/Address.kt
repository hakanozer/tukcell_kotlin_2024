package com.cevdetkilickeser.cevdetkilickeservize3.model


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("coordinates")
    val coordinates: Coordinates,
    @SerializedName("postalCode")
    val postalCode: String,
    @SerializedName("state")
    val state: String
)