package com.umutyusufcinar.odev8recipeapp.configs

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val base_URL="https://dummyjson.com/"
    private var retrofit: Retrofit?=null

    private var client= OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS).build()

    fun getClient(): Retrofit {
        if(retrofit==null){
            retrofit= Retrofit.Builder().baseUrl(base_URL).addConverterFactory(GsonConverterFactory.create()).client(
                client).build()
        }

        return retrofit as Retrofit
    }


}