package com.tlh.classicrecipe.service

import com.tlh.classicrecipe.model.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface IDummyService {
    @GET("recipes/search")
    fun getRecipe(@Query("q")search:String):Call<Recipes>
}