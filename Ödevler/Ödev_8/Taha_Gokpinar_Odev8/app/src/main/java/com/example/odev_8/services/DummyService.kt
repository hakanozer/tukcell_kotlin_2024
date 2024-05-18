package com.example.odev_8.services

import com.example.odev_8.models.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface DummyService {
    @GET("recipes")
    fun getRecipes() : Call<Recipes>
}