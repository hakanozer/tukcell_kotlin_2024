package com.example.eray_altilar_vize_3.domain.model

import java.io.Serializable

data class UserModel(
    val address: AddressModel,
    val age: Int,
    val bank: BankModel,
    val birthDate: String,
    val bloodGroup: String,
    val company: CompanyModel,
    val crypto: CryptoModel,
    val domain: String,
    val ein: String,
    val email: String,
    val eyeColor: String,
    val firstName: String,
    val gender: String,
    val hair: HairModel,
    val height: Int,
    val id: Int,
    val image: String,
    val ip: String,
    val lastName: String,
    val macAddress: String,
    val maidenName: String,
    val password: String,
    val phone: String,
    val ssn: String,
    val university: String,
    val userAgent: String,
    val username: String,
    val weight: Double
): Serializable