package com.beyzaparlak.beyza_parlak_vize_3.modell

import java.io.Serializable

data class Crypto(
    val coin: String,
    val network: String,
    val wallet: String
): Serializable
