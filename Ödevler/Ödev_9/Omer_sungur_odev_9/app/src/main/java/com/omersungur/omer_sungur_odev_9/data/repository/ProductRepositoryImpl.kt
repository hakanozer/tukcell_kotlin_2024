package com.omersungur.omer_sungur_odev_9.data.repository

import com.omersungur.omer_sungur_odev_9.core.Resource
import com.omersungur.omer_sungur_odev_9.data.mapper.toProductResult
import com.omersungur.omer_sungur_odev_9.data.remote.ProductService
import com.omersungur.omer_sungur_odev_9.domain.model.ProductResult
import com.omersungur.omer_sungur_odev_9.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productService: ProductService
) : ProductRepository {

    override fun getProducts(limit: Int, skip: Int): Flow<Resource<ProductResult>> = flow {
        emit(Resource.Loading(isLoading = true))
        val products = productService.getProductsWithPaging(limit, skip)
        emit(Resource.Success(data = products.toProductResult()))
    }
}