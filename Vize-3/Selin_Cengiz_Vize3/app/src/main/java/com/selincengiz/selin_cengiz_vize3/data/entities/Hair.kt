package com.selincengiz.selin_cengiz_vize3.data.entities


import com.google.gson.annotations.SerializedName

data class Hair(
    @SerializedName("color")
    val color: String?,
    @SerializedName("type")
    val type: String?
)