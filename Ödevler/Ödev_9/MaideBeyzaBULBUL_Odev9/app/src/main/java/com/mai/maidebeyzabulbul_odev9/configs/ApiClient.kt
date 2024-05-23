package com.mai.days9.configs

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val Base_URL = "https://dummyjson.com"//service yazarken sürekli sürekli url vermemek için
    private val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    }

    private val client = OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    fun getClient() : Retrofit {
        return retrofit
    }

}