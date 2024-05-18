package com.example.yunusemreceylan_odev8.data.api

import com.example.yunusemreceylan_odev8.data.model.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("recipes")
    fun getRecipe(@Query("q") search: String): Call<Recipes>
}