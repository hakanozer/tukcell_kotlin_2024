package com.selincengiz.selin_cengiz_odev9.domain.usecase

import androidx.paging.PagingData
import com.selincengiz.selin_cengiz_odev9.domain.entities.ProductUI
import com.selincengiz.selin_cengiz_odev9.domain.repo.IProductsRepo
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val repository: IProductsRepo) {
    operator fun invoke(): Flow<PagingData<ProductUI>> {
        return repository.getProducts().flow
    }
}