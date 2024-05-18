package com.example.odev8.services

import com.example.odev8.models.RecipeList
import retrofit2.Call
import retrofit2.http.GET

interface IRecipeService {

    @GET("recipes")
    fun getRecipes(): Call<RecipeList>
}