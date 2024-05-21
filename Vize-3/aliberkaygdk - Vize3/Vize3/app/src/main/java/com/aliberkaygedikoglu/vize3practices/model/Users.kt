package com.aliberkaygedikoglu.vize3practices.model

import java.io.Serializable

data class Users (
    val users: List<User>,
    val total: Long,
    val skip: Long,
    val limit: Long
):Serializable

data class User (
    val id: Long,
    val firstName: String,
    val lastName: String,
    val maidenName: String,
    val age: Long,
    val gender: String,
    val email: String,
    val phone: String,
    val username: String,
    val password: String,
    val birthDate: String,
    val image: String,
    val bloodGroup: String,
    val height: Long,
    val weight: Double,
    val eyeColor: String,
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
):Serializable

data class Address (
    val address: String,
    val city: String? = null,
    val coordinates: Coordinates,
    val postalCode: String,
    val state: String
):Serializable

data class Coordinates (
    val lat: Double,
    val lng: Double
):Serializable

data class Bank (
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
):Serializable

data class Company (
    val address: Address,
    val department: String,
    val name: String,
    val title: String
):Serializable

data class Crypto (
    val coin: String,
    val wallet: String,
    val network: String
) :Serializable

data class Hair (
    val color: String,
    val type: String
):Serializable

