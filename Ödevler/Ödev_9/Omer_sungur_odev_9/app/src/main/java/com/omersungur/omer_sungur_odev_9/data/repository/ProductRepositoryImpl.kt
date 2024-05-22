package com.omersungur.omer_sungur_odev_9.data.repository

import com.omersungur.omer_sungur_odev_9.core.Resource
import com.omersungur.omer_sungur_odev_9.domain.model.ProductResult
import com.omersungur.omer_sungur_odev_9.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl: ProductRepository {

    override fun getProducts(): Flow<Resource<ProductResult>> = flow {
        emit(Resource.Loading(isLoading = true))
    }
}