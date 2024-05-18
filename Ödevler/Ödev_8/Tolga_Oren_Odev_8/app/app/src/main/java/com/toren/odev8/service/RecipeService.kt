package com.toren.odev8.service

import com.toren.odev8.model.RecipesDto
import retrofit2.Call
import retrofit2.http.GET

interface RecipeService {

    @GET("recipes")
    fun getRecipes(): Call<RecipesDto>

}