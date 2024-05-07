package com.bengisusahin.bengisu_sahin_vize02.models

import java.io.Serializable

// putExtrada Plant objesini döndürebilmek için data classı serializable yaptım
data class Plant(
    val COMMON: String,
    val BOTANICAL: String,
    val ZONE: String,
    val LIGHT: String,
    val PRICE: String,
    val AVAILABILITY: String,

) : Serializable
