package com.works.days_9.services


import com.works.days_9.models.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface DummyService {

    @GET("recipes")
    fun getProducts() : Call<Recipes>

}