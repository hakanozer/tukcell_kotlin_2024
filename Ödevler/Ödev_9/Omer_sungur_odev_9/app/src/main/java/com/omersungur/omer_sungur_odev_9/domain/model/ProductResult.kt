package com.omersungur.omer_sungur_odev_9.domain.model

data class ProductResult(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)