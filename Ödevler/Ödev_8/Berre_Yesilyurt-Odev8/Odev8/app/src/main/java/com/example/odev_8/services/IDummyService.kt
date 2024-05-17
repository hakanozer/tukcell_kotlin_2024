package com.example.odev_8.services


import com.example.odev_8.Models.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface IDummyService {
    @GET("recipes")
    fun getRecipes(): Call<Recipes>
}