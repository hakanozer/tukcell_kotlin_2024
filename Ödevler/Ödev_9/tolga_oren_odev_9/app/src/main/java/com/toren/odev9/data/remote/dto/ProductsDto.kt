package com.toren.odev9.data.remote.dto

import com.toren.odev9.domain.model.Product

data class ProductsDto(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)