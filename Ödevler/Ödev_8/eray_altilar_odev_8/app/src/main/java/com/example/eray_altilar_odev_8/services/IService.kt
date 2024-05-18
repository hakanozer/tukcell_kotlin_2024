package com.example.eray_altilar_odev_8.services

import com.example.eray_altilar_odev_8.model.Recipes
import retrofit2.Call
import retrofit2.http.GET


interface IService {

    @GET("recipes")
    fun getRecipes() : Call<Recipes>

}