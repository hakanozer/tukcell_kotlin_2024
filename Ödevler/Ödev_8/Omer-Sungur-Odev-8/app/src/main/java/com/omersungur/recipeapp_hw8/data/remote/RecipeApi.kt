package com.omersungur.recipeapp_hw8.data.remote

import com.omersungur.recipeapp_hw8.data.remote.dto.Recipe
import retrofit2.http.GET

interface RecipeApi {

    @GET("recipes")
    suspend fun getRecipes(): Recipe
}