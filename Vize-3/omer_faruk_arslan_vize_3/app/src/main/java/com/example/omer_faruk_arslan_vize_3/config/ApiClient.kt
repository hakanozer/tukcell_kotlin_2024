package com.example.omer_faruk_arslan_vize_3.config

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private val Base_Url = "https://dummyjson.com/"

    private val client = OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    private val retrofit : Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getClient() : Retrofit
    {
        return retrofit
    }
}