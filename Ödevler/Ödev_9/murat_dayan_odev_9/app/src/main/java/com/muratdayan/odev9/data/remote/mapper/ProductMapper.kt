package com.muratdayan.odev9.data.remote.mapper

import com.muratdayan.odev9.data.remote.dto.ProductDto
import com.muratdayan.odev9.domain.models.Product

fun ProductDto.toProduct():Product{
    return Product(
        id = id,
        title = title,
        price = price,
        description = description,
        discountPercentage = discountPercentage,
        brand = brand,
        stock = stock,
        images = images,
        category = category,
        thumbnail = thumbnail,
        rating = rating
        )
}