package com.aliberkaygedikoglu.odev8.service

import com.aliberkaygedikoglu.odev8.model.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface IService {

    @GET("recipes")
    fun getRecipes(): Call<Recipes>
}