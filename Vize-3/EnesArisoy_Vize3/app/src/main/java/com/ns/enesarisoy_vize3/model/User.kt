package com.ns.enesarisoy_vize3.model

import java.io.Serializable

data class User(
    val address: Address? = null,
    val age: Int? = null,
    val bank: Bank? = null,
    val birthDate: String? = null,
    val bloodGroup: String? = null,
    val company: Company? = null,
    val crypto: Crypto? = null,
    val domain: String? = null,
    val ein: String? = null,
    val email: String? = null,
    val eyeColor: String? = null,
    val firstName: String? = null,
    val gender: String? = null,
    val hair: Hair? = null,
    val height: Int? = null,
    val id: Int? = null,
    val image: String? = null,
    val ip: String? = null,
    val lastName: String? = null,
    val macAddress: String? = null,
    val maidenName: String? = null,
    val password: String? = null,
    val phone: String? = null,
    val ssn: String? = null,
    val university: String? = null,
    val userAgent: String? = null,
    val username: String? = null,
    val weight: Double? = null,
    val isLoading: Boolean = false
): Serializable