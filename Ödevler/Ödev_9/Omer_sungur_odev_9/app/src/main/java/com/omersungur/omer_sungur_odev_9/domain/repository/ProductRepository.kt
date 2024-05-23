package com.omersungur.omer_sungur_odev_9.domain.repository


import com.omersungur.omer_sungur_odev_9.core.Resource
import com.omersungur.omer_sungur_odev_9.domain.model.ProductResult
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProducts(limit: Int, skip: Int): Flow<Resource<ProductResult>>
}