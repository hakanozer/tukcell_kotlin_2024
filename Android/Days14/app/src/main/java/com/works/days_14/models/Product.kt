package com.works.days_14.models

data class Product(
    val key: String,
    val value: ProductVal
)

data class ProductVal (
    val title: String = "",
    val detail: String = "",
    val price: Int = 0
)
