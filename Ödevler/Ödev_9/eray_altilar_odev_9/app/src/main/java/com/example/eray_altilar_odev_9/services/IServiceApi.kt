package com.example.eray_altilar_odev_9.services

import com.example.eray_altilar_odev_9.model.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IServiceApi {

    @GET("products")
    fun getProducts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Call<Products>
}