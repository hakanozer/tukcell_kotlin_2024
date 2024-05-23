package com.bengisusahin.days_9.services

import Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface IDummyService {
    @GET("products")
    fun getProducts(@Query("limit") limit: Long, @Query("skip") skip: Long): Call<Products>
}