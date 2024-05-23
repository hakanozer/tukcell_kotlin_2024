package com.example.odev9.services

import com.example.odev9.models.ProductsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("products")
    fun getAllProducts(): Call<ProductsData>

    @GET("products")
    fun getProductsByLimit(
        @Query("limit") limit: String = "10",
        @Query("skip") skip: String
    ): Call<ProductsData>

}