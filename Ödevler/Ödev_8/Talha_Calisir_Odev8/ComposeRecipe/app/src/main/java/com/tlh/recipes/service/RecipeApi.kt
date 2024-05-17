package com.tlh.recipes.service

import com.tlh.recipes.model.RecipeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RecipeApi {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse
}

object RetrofitInstance {
    private const val BASE_URL = "https://dummyjson.com/"

    val api: RecipeApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }
}
