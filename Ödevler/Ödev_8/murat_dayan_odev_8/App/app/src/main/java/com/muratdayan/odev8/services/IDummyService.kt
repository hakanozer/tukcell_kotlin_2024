package com.muratdayan.odev8.services

import com.muratdayan.odev8.models.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IDummyService {

    @GET("recipes")
    fun getAllRecipes(): Call<Recipes>

    // searching işlemi @Query ile yapıldı
    @GET("recipes/search")
    fun searchRecipes(@Query("q") searchText: String): Call<Recipes>


}