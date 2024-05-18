package com.example.emre_bitik_odev_8.services

import com.example.emre_bitik_odev_8.models.Products
import retrofit2.Call
import retrofit2.http.GET

interface DummyService {

    @GET("recipes")
    fun getProducts() : Call<Products>
}