package com.yeceylan.yunusemreceylan_snav3.data.model

import java.io.Serializable

data class Crypto(
    val coin: String,
    val network: String,
    val wallet: String
): Serializable