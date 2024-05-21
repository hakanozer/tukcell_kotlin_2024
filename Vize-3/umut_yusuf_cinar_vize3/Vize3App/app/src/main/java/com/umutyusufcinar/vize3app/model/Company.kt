package com.umutyusufcinar.vize3app.model

import java.io.Serializable

data class Company(
    val address: Address,
    val department: String,
    val name: String,
    val title: String
): Serializable