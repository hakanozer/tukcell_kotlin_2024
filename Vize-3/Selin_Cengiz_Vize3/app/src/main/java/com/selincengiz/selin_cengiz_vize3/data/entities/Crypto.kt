package com.selincengiz.selin_cengiz_vize3.data.entities


import com.google.gson.annotations.SerializedName

data class Crypto(
    @SerializedName("coin")
    val coin: String?,
    @SerializedName("network")
    val network: String?,
    @SerializedName("wallet")
    val wallet: String?
)