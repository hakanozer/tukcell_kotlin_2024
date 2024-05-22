package com.sercancelik.odev9.service

import com.sercancelik.odev9.models.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products/")
    fun getProducts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Call<ProductsResponse>
}
