package com.muratdayan.odev9.presentation.main_screen

import com.muratdayan.odev9.domain.models.Product

data class ProductState(
    val products: List<Product>?= emptyList(),
    val isLoading: Boolean = false,
    val errorMsg:String?= ""
)