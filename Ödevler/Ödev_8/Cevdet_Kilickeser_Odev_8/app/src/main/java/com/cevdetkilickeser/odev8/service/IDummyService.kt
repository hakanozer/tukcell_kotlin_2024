package com.cevdetkilickeser.odev8.service

import com.cevdetkilickeser.odev8.model.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface IDummyService {

    @GET("/recipes")
    fun getRecipes(): Call<Recipes>

}