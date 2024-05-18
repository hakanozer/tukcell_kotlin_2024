package com.example.yusuf_mucahit_solmaz_odev_8.data.retrofit


import com.example.yusuf_mucahit_solmaz_odev_8.data.model.RootReciepe
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("recipes")
    fun getProducts() : Call<RootReciepe>

}