package com.muratdayan.odev9.data.remote.services

import com.muratdayan.odev9.data.remote.dto.ProductsRespondDto
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("products")
    suspend fun getAllProducts() : ProductsRespondDto

    @GET("products")
    suspend fun getAllProductsWithQuery(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): ProductsRespondDto
}