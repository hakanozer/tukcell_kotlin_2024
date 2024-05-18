package com.omersungur.recipeapp_hw8.di

import com.omersungur.recipeapp_hw8.data.remote.RecipeApi
import com.omersungur.recipeapp_hw8.data.repository.RecipeRepositoryImpl
import com.omersungur.recipeapp_hw8.domain.repository.RecipeRepository
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
    fun provideRepository(recipeApi: RecipeApi): RecipeRepository {
        return RecipeRepositoryImpl(recipeApi)
    }
}