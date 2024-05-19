package com.omersungur.omer_sungur_odev_9.data.remote.dto

data class ProductDtoResult(
    val limit: Int,
    val products: List<ProductDto>,
    val skip: Int,
    val total: Int
)