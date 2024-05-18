package com.bengisusahin.bengisu_sahin_odev_08.services

import com.bengisusahin.bengisu_sahin_odev_08.models.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface IDummyService {
    @GET("recipes")
    fun getRecipes(): Call<Recipes>
}