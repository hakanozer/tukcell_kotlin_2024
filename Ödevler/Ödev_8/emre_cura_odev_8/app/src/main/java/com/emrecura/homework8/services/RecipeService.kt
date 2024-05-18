package com.emrecura.homework8.services

import com.emrecura.homework8.models.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET("recipes")
    fun getRecipes() : Call<Recipes>

    @GET("recipes/search")
    fun searchRecipes(@Query("q") query: String): Call<Recipes>
}