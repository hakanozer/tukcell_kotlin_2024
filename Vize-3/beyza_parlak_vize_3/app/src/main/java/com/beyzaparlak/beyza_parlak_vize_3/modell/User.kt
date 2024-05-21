package com.beyzaparlak.beyza_parlak_vize_3.modell


import java.io.Serializable

data class User(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserX>
): Serializable