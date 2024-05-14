package com.works.days_9.services

import com.works.days_9.models.Products
import retrofit2.Call
import retrofit2.http.GET

interface DummyService {

    @GET("products")
    fun getProducts() : Call<Products>

}