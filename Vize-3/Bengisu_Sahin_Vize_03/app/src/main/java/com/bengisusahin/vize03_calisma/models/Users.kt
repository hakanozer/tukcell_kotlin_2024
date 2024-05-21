package com.bengisusahin.vize03_calisma.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Users (
    val users: List<User>,
    val total: Long,
    val skip: Long,
    val limit: Long
)

data class User (
    val id: Long,
    val firstName: String,
    val lastName: String,
    val maidenName: String,
    val age: Long,
    val gender: Gender,
    val email: String,
    val phone: String,
    val username: String,
    val password: String,
    val birthDate: String,
    val image: String,
    val bloodGroup: String,
    val height: Long,
    val weight: Double,
    val eyeColor: EyeColor,
    val hair: Hair,
    val domain: String,
    val ip: String,
    val address: Address,
    val macAddress: String,
    val university: String,
    val bank: Bank,
    val company: Company,
    val ein: String,
    val ssn: String,
    val userAgent: String,
    val crypto: Crypto
) : Serializable

data class Address (
    val address: String,
    val city: String? = null,
    val coordinates: Coordinates,
    val postalCode: String,
    val state: String
) : Serializable

data class Coordinates (
    val lat: Double,
    val lng: Double
) : Serializable

data class Bank (
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
) : Serializable

data class Company (
    val address: Address,
    val department: String,
    val name: String,
    val title: String
) : Serializable

data class Crypto (
    val coin: Coin,
    val wallet: Wallet,
    val network: Network
) : Serializable

enum class Coin {
    Bitcoin
}

enum class Network {
    EthereumERC20
}

enum class Wallet {
    The0Xb9Fc1004Bfe7702De522516Cf34A5Da41C4Ef2B5,
    The0Xb9Fc2Fe63B2A6C003F1C324C3Bfa53259162181A,
    The0Xb9Fc4B4B855Bc44Eb30D5E36Fd18F491F44A15B7,
    The0Xb9Fe6979A82Fb43Fdd9Ba9F446846Dc4Dfca3Deb
}

enum class EyeColor {
    Amber,
    Blue,
    Brown,
    Gray,
    Green
}

enum class Gender {
    female,
    male
}

data class Hair (
    val color: Color,
    val type: Type
) : Serializable

enum class Color {
    Auburn,
    Black,
    Blond,
    Brown,
    Chestnut
}

// because of the name is "Very curly" in dummyJson I used SerializedName
enum class Type {
    Curly,
    Straight,
    Strands,
    @SerializedName("Very curly")
    VeryCurly,
    Wavy
}
