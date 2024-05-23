package com.example.yunusemreceylan_odev8.data.model

import java.io.Serializable

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
): Serializable

data class ProductList(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
