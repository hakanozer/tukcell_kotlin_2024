package com.example.listegzersiz.services

import com.example.listegzersiz.models.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDumyService {

    @GET("products")
    fun getProduct(@Query("limit") limit:Int,@Query("skip") skip:Int):Call<Products>
}