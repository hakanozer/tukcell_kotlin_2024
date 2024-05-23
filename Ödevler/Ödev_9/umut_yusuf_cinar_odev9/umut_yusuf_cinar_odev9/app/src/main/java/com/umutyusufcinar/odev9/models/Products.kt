package com.umutyusufcinar.odev9.models
//ürünler için kullanmak adına bir model oluşturuyorum ki JSON patlamasın
//derste kullanıldığı gibi data class yapıları kullanacağım

data class Products (
    val products: List<Product>,
    val total: Long,
    val skip: Long,
    val limit: Long
)

data class Product (
    val id: Long,
    val title: String,
    val description: String,
    val price: Long,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Long,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)
