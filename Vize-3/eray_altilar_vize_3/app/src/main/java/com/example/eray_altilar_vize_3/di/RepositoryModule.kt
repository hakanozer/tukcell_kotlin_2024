package com.example.eray_altilar_vize_3.di

import com.example.eray_altilar_vize_3.data.remote.api.UsersApi
import com.example.eray_altilar_vize_3.data.repository.UserRepositoryImpl
import com.example.eray_altilar_vize_3.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(userApi: UsersApi): UserRepository {
        return UserRepositoryImpl(userApi)
    }
}