package com.example.yusuf_mucahit_solmaz_odev_9.data.remote.model

data class RootProduct(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)