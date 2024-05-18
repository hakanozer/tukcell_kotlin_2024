package com.omersungur.recipeapp_hw8.di

import com.omersungur.recipeapp_hw8.domain.repository.RecipeRepository
import com.omersungur.recipeapp_hw8.domain.usecase.GetRecipesUseCase
import com.omersungur.recipeapp_hw8.domain.usecase.RecipeUseCases
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
    fun provideUseCases(
        recipeRepository: RecipeRepository,
    ): RecipeUseCases {
        return RecipeUseCases(
            getRecipeUseCase = GetRecipesUseCase(recipeRepository)
        )
    }
}