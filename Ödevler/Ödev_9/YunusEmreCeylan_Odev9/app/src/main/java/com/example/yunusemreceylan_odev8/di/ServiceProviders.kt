package com.example.yunusemreceylan_odev8.di

import com.example.yunusemreceylan_odev8.data.api.ProductService
import com.example.yunusemreceylan_odev8.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceProviders {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
         val client = OkHttpClient
            .Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
            //TODO
        val retrofit: Retrofit by lazy {
            Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        return retrofit
    }

    @Singleton
    @Provides
    fun provideProductService(
        retrofit: Retrofit
    ): ProductService {
        return retrofit
            .create(ProductService::class.java)
    }
}