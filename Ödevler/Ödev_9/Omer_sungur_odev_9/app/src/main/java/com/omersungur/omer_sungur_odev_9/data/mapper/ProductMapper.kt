package com.omersungur.omer_sungur_odev_9.data.mapper

import com.omersungur.omer_sungur_odev_9.data.remote.dto.ProductDto
import com.omersungur.omer_sungur_odev_9.data.remote.dto.ProductDtoResult
import com.omersungur.omer_sungur_odev_9.domain.model.ProductResult
import com.omersungur.omer_sungur_odev_9.domain.model.Product

fun ProductDtoResult.toProductResult(): ProductResult {
   return ProductResult(
       limit = limit,
       products = products.map { it.toProduct() },
       skip = skip,
       total = total
   )
}

fun ProductDto.toProduct(): Product {
    return Product(
        brand = brand,
        category = category,
        description = description,
        discountPercentage = discountPercentage,
        id = id,
        images = images,
        price = price,
        rating = rating,
        stock = stock,
        thumbnail = thumbnail,
        title = title
    )
}