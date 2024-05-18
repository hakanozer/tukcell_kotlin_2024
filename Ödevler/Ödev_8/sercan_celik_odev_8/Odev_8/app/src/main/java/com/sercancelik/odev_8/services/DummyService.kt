package com.sercancelik.odev_8.services

import com.sercancelik.odev_8.models.Recipe
import com.sercancelik.odev_8.models.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {

    @GET("recipes")
    fun getRecipes(): Call<Recipes>

    @GET("recipes/{id}")
    fun getRecipe(@Path("id") id: Long): Call<Recipe>

}