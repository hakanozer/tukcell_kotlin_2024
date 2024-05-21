package com.cevdetkilickeser.cevdetkilickeservize3.model


import com.google.gson.annotations.SerializedName

data class Hair(
    @SerializedName("color")
    val color: String,
    @SerializedName("type")
    val type: String
)