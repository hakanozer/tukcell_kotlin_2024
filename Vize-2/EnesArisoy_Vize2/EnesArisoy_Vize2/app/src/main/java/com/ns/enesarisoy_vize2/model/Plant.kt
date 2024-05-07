package com.ns.enesarisoy_vize2.model

import java.io.Serializable

data class Plant(
    val commonName: String,
    val botanicalName: String,
    val zone: String,
    val light: String,
    val price: String,
    val availability: String
): Serializable