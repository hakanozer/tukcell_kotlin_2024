package com.beyzaparlak.odev8.services


import com.beyzaparlak.odev8.models.Recipes
import retrofit2.http.GET
import retrofit2.Call

interface IDummyService {

    @GET("recipes")
    fun getProducts(): Call<Recipes>
}