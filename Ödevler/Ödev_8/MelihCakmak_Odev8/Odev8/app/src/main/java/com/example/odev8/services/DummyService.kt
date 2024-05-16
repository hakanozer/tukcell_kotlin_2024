package com.example.odev8.services

import com.example.odev8.models.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface DummyService {

    @GET("recipes")
    fun getProducts() : Call<Recipes>

}