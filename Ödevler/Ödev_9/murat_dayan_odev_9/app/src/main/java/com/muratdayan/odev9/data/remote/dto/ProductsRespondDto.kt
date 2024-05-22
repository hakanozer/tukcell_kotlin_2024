package com.muratdayan.odev9.data.remote.dto

data class ProductsRespondDto(
    val limit: Int,
    val products: List<ProductDto>,
    val skip: Int,
    val total: Int
)