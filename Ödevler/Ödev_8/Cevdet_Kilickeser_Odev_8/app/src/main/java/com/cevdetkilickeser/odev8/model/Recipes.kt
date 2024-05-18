package com.cevdetkilickeser.odev8.model


import com.google.gson.annotations.SerializedName

data class Recipes(
    @SerializedName("limit") val limit: Int,
    @SerializedName("recipes") val recipes: List<Recipe>,
    @SerializedName("skip") val skip: Int,
    @SerializedName("total") val total: Int
)