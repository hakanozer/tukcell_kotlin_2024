package com.example.odev9.models

import java.io.Serializable

data class ProductsData (
    val products: List<Product>,
    val total: Long,
    val skip: Long,
    val limit: Long
) : Serializable

data class Product (
    val id: Long,
    val title: String,
    val description: String,
    val category: Category,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Long,
    val tags: List<String>,
    val brand: String? = null,
    val sku: String,
    val weight: Long,
    val dimensions: Dimensions,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: AvailabilityStatus,
    val reviews: List<Review>,
    val returnPolicy: ReturnPolicy,
    val minimumOrderQuantity: Long,
    val meta: Meta,
    val images: List<String>,
    val thumbnail: String
)

enum class AvailabilityStatus {
    InStock,
    LowStock
}

enum class Category {
    Beauty,
    Fragrances,
    Furniture,
    Groceries
}

data class Dimensions (
    val width: Double,
    val height: Double,
    val depth: Double
)

data class Meta (
    val createdAt: String,
    val updatedAt: String,
    val barcode: String,
    val qrCode: String
)

enum class ReturnPolicy {
    NoReturnPolicy,
    The30DaysReturnPolicy,
    The60DaysReturnPolicy,
    The7DaysReturnPolicy,
    The90DaysReturnPolicy
}

data class Review (
    val rating: Long,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String
)
