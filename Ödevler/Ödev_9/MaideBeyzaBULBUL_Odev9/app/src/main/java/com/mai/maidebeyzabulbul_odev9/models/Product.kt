package com.mai.maidebeyzabulbul_odev9.models


data class Product (
    val products: List<ProductElement>,
    val total: Long,
    val skip: Long,
    val limit: Long
)

data class ProductElement(
    val id: Long,
    val title: String,
    val description: String,
    val price: Long,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Long,
    val brand: String,
    val category: Category,
    val thumbnail: String,
    val images: List<String>
)

enum class Category {
    Groceries,
    HomeDecoration
}
