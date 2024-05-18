package com.mai.maidebeyzabulbul_odev_8.service

import com.mai.maidebeyzabulbul_odev_8.models.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("recipes")
    fun getRecipes() : Call<Recipes>

    @GET("/recipes/search")
    fun searchRecipes(@Query("q") query: String): Call<Recipes>

}