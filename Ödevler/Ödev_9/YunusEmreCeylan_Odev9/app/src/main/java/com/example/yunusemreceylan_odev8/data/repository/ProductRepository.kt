package com.example.yunusemreceylan_odev8.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.yunusemreceylan_odev8.data.api.ProductService
import com.example.yunusemreceylan_odev8.data.paging.ProductPagingSource
import com.example.yunusemreceylan_odev8.data.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepository @Inject constructor(private val service: ProductService) {

    fun getSearchResults(query: String): Flow<PagingData<Product>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { ProductPagingSource(service, query) }
        ).flow
    }
}
