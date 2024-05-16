package com.canerdedeoglu.odev_8.service

import com.canerdedeoglu.odev_8.model.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("recipes/search")
    fun getRecipe(@Query("q") search: String): Call<Recipes>
}