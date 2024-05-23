package com.selincengiz.selin_cengiz_odev9.data.entities


import com.google.gson.annotations.SerializedName

data class ResponseProducts(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("products")
    val products: List<Product>?,
    @SerializedName("skip")
    val skip: Int?,
    @SerializedName("total")
    val total: Int?
)