package com.ns.enesarisoy_odev8.services

import com.ns.enesarisoy_odev8.model.Recipe
import com.ns.enesarisoy_odev8.model.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {

    @GET("recipes")
    fun getRecipes(): Call<RecipeResponse>

    @GET("recipes/search")
    fun searchRecipes(
        @Query("q") query: String
    ): Call<RecipeResponse>

    @GET("recipes/{id}")
    fun getRecipe(
        @Path("id") id: Int
    ): Call<Recipe>
}