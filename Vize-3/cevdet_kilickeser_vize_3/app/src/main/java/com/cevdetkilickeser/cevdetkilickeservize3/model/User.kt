package com.cevdetkilickeser.cevdetkilickeservize3.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("address")
    val address: Address,
    @SerializedName("age")
    val age: Int,
    @SerializedName("bank")
    val bank: Bank,
    @SerializedName("birthDate")
    val birthDate: String,
    @SerializedName("bloodGroup")
    val bloodGroup: String,
    @SerializedName("company")
    val company: Company,
    @SerializedName("crypto")
    val crypto: Crypto,
    @SerializedName("domain")
    val domain: String,
    @SerializedName("ein")
    val ein: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("eyeColor")
    val eyeColor: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hair")
    val hair: Hair,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("ip")
    val ip: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("macAddress")
    val macAddress: String,
    @SerializedName("maidenName")
    val maidenName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("ssn")
    val ssn: String,
    @SerializedName("university")
    val university: String,
    @SerializedName("userAgent")
    val userAgent: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("weight")
    val weight: Double
)