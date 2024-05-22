package com.muratdayan.odev9.domain.repository

import androidx.paging.PagingData
import com.muratdayan.odev9.core.common.Resource
import com.muratdayan.odev9.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllProducts() : Flow<Resource<List<Product>>>

    fun getAllProductsWithQuery(limit:Int,skip:Int) : Flow<Resource<List<Product>>>

}