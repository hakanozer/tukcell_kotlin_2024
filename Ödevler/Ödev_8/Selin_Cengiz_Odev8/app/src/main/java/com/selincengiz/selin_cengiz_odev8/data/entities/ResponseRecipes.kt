package com.selincengiz.selin_cengiz_odev8.data.entities


import com.google.gson.annotations.SerializedName

data class ResponseRecipes(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("recipes")
    val recipes: List<Recipe>?,
    @SerializedName("skip")
    val skip: Int?,
    @SerializedName("total")
    val total: Int?
)