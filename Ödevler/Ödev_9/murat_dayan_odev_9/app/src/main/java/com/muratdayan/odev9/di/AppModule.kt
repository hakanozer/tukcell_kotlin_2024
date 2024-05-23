package com.muratdayan.odev9.di

import com.muratdayan.odev9.core.utils.Constants
import com.muratdayan.odev9.data.remote.repository.RepositoryImpl
import com.muratdayan.odev9.data.remote.services.IDummyService
import com.muratdayan.odev9.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofitInstance():Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideIDummyService(retrofit: Retrofit) : IDummyService = retrofit.create(IDummyService::class.java)

    @Provides
    @Singleton
    fun providesRepository(iDummyService: IDummyService): Repository{
        return RepositoryImpl(iDummyService)
    }




}