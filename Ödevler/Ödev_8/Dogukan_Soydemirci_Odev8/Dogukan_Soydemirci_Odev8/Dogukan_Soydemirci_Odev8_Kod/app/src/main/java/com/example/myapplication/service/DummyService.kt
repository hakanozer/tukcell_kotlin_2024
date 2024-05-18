package com.example.myapplication.service


import android.telecom.Call
import com.example.myapplication.model.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {

    @GET("Recipes")
    fun getProducts() : Call<Recipes>

}