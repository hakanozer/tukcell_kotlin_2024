package com.umutyusufcinar.odev8recipeapp.services

import com.umutyusufcinar.odev8recipeapp.models.Recipes
import retrofit2.Call
import retrofit2.http.GET
//servis işlemlerini evirebilmek için kullanıdğım retrofit ve gson ile beraber servis için
//derste gördüğüm gibi interface yazıyorum
interface IDummyService {
    @GET("recipes")
    fun getRecipes(): Call<Recipes>
}