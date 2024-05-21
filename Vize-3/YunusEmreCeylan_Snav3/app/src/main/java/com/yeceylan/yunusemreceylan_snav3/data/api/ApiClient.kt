package com.yeceylan.yunusemreceylan_snav3.data.api

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    const val BASE_URL = "https://dummyjson.com/"

    private val client = OkHttpClient
        .Builder()
        .addInterceptor(OkHttpProfilerInterceptor())
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getClient(): Retrofit {
        return retrofit
    }
}