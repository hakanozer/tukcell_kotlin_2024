package com.selincengiz.selin_cengiz_vize3.data.entities


import com.google.gson.annotations.SerializedName

data class ResponseUsers(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("skip")
    val skip: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("users")
    val users: List<User>?
)