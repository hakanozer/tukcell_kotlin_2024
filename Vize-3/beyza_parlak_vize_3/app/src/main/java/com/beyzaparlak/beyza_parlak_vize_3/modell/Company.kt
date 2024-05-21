package com.beyzaparlak.beyza_parlak_vize_3.modell

import java.io.Serializable

data class Company(
    val address: Address,
    val department: String,
    val name: String,
    val title: String
): Serializable
