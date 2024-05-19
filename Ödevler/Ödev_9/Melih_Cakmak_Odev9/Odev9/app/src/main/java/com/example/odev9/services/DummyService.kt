package com.example.odev9.services

import com.example.odev9.models.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {

    @GET("products")
    fun getProducts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Call<Products>

}
