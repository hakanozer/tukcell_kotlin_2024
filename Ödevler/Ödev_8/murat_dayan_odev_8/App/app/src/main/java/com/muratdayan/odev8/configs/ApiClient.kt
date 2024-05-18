package com.muratdayan.odev8.configs

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val BASE_URL = "https://dummyjson.com/"

    private val client = OkHttpClient
        .Builder()
        .readTimeout(60,TimeUnit.SECONDS)
        .build()

    // retrofit nesnesinin oluşturulması
    private val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getClient(): Retrofit{
        return retrofit
    }


}