package com.canerdedeoglu.days_9.services

import com.canerdedeoglu.days_9.models.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("products")
    suspend fun getProducts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): Products
}