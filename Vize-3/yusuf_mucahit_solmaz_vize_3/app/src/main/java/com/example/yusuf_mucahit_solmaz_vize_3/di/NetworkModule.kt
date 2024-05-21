package com.example.yusuf_mucahit_solmaz_vize_3.di

import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.api.ApiClient
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.api.ApiService
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.repository.FilterRepository
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiClient.getClient().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideFilterRepository(apiService: ApiService): FilterRepository {
        return FilterRepository(apiService)
    }
}