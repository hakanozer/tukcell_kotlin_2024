package com.beyzaparlak.vize2.service

import java.io.Serializable

data class Plant(
    val COMMON : String,
    val BOTANICAL : String,
    val ZONE : String,
    val LIGHT : String,
    val PRICE : String,
    val AVAILABILITY : String
):Serializable
