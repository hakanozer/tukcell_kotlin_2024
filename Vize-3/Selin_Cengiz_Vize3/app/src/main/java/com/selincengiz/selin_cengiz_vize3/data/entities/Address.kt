package com.selincengiz.selin_cengiz_vize3.data.entities


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("address")
    val address: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("coordinates")
    val coordinates: Coordinates?,
    @SerializedName("postalCode")
    val postalCode: String?,
    @SerializedName("state")
    val state: String?
)