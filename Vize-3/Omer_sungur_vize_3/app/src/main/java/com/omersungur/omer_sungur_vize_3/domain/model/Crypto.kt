package com.omersungur.omer_sungur_vize_3.domain.model

import java.io.Serializable

data class Crypto(
    val coin: String,
    val network: String,
    val wallet: String
): Serializable
