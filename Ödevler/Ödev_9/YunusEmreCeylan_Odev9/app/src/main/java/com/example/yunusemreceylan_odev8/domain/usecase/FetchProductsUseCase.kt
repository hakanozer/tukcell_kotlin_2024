package com.example.yunusemreceylan_odev8.domain.usecase

import androidx.paging.PagingData
import com.example.yunusemreceylan_odev8.data.model.Product
import com.example.yunusemreceylan_odev8.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchProductsUseCase @Inject constructor(private val repository: ProductRepository) {

    operator fun invoke(query: String): Flow<PagingData<Product>> {
        return repository.getSearchResults(query)
    }
}
