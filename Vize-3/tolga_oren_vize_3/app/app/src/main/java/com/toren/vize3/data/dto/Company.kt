package com.toren.vize3.data.dto

import java.io.Serializable

data class Company(
    val address: Address,
    val department: String,
    val name: String,
    val title: String
) : Serializable