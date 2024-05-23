package com.beyzaparlak.odev9.services

import com.beyzaparlak.odev9.models.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("products")
    fun getProducts(
        @Query("page") page: Int,
        @Query("size") size: Int)
    : Call<Products>
}