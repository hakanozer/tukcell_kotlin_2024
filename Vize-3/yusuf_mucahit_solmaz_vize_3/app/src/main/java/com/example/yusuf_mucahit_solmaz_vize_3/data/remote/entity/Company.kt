package com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity

import java.io.Serializable

data class Company(
    val address: Address,
    val department: String,
    val name: String,
    val title: String
): Serializable