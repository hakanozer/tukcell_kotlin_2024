package com.omersungur.omer_sungur_odev_9.domain.usecase.get_products

import com.omersungur.omer_sungur_odev_9.core.Resource
import com.omersungur.omer_sungur_odev_9.domain.model.ProductResult
import com.omersungur.omer_sungur_odev_9.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {

    operator fun invoke(limit: Int, skip: Int): Flow<Resource<ProductResult>> {
        return productRepository.getProducts(limit, skip)
    }
}