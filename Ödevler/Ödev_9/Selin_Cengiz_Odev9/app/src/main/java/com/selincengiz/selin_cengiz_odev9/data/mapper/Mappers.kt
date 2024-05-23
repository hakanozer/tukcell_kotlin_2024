package com.selincengiz.selin_cengiz_odev9.data.mapper

import com.selincengiz.selin_cengiz_odev9.data.entities.Product
import com.selincengiz.selin_cengiz_odev9.domain.entities.ProductUI

fun Product.mapToProductUI(): ProductUI {
    return ProductUI(
        id,
        brand,
        category,
        description,
        discountPercentage,
        images,
        price,
        rating,
        stock,
        thumbnail,
        title
    )
}

