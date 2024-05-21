package com.example.eray_altilar_vize_3.domain.model

data class CompanyModel(
    val address: AddressModel,
    val department: String,
    val name: String,
    val title: String
)