package com.selincengiz.selin_cengiz_odev10.di

import com.selincengiz.selin_cengiz_odev10.domain.repo.IUserRepo
import com.selincengiz.selin_cengiz_odev10.domain.usecase.LoginUseCase
import com.selincengiz.selin_cengiz_odev10.domain.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideLoginUseCase(userRepo: IUserRepo) =
        LoginUseCase(userRepo = userRepo)

    @Provides
    @Singleton
    fun provideRegisterUseCase(userRepo: IUserRepo) =
        RegisterUseCase(userRepo = userRepo)

}