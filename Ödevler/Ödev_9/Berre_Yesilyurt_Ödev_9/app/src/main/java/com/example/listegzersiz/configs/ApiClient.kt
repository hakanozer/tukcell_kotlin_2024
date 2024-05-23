package com.example.listegzersiz.configs

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val BASE_URL="https://dummyjson.com/"
    private var retrofit:Retrofit?=null

    private val client=OkHttpClient.Builder().readTimeout(60,TimeUnit.SECONDS).build()

    fun getClient(): Retrofit {
        retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build()

        return retrofit as Retrofit

    }
}