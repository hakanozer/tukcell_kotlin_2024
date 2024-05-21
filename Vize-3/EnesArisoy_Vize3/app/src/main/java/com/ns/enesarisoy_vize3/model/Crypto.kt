package com.ns.enesarisoy_vize3.model

import java.io.Serializable

data class Crypto(
    val coin: String,
    val network: String,
    val wallet: String
) : Serializable