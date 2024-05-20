package com.ns.enesarisoy_odev9.model

data class Product(
    val brand: String? = null,
    val category: String? = null,
    val description: String? = null,
    val discountPercentage: Double? = null,
    val id: Int? = null,
    val images: List<String>? = null,
    val price: Int? = null,
    val rating: Double? = null,
    val stock: Int? = null,
    val thumbnail: String? = null,
    val title: String? = null,
    val isLoading: Boolean = false
)