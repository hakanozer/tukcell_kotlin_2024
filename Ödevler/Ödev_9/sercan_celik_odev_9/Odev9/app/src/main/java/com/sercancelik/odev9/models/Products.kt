package com.sercancelik.odev9.models

data class ProductsResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int,
)

data class Product(
    val id: Long,
    val title: String,
    val description: String,
    val price: Long,
    val discountPercentage: Double,
    val rating: Float,
    val stock: Long,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>,
)
