package com.omersungur.omer_sungur_vize_3.domain.model

import java.io.Serializable

data class Company(
    val address: Address,
    val department: String,
    val name: String,
    val title: String
): Serializable
