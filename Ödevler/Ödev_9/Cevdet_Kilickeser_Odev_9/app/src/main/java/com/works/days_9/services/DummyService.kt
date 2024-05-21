package com.works.days_9.services

import com.works.days_9.models.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {

    @GET("products")
    fun getProducts(@Query("skip") skip: Int, @Query("limit") limit: Int) : Call<Products>

}