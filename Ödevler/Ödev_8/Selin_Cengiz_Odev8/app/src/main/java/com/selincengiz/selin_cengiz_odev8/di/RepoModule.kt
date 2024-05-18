package com.selincengiz.selin_cengiz_odev8.di

import com.selincengiz.selin_cengiz_odev8.data.repo.RecipesRepoImpl
import com.selincengiz.selin_cengiz_odev8.data.repo.RoomRepoImpl
import com.selincengiz.selin_cengiz_odev8.data.source.local.IRecipeDao
import com.selincengiz.selin_cengiz_odev8.data.source.remote.IRecipesService
import com.selincengiz.selin_cengiz_odev8.domain.repo.IRecipesRepo
import com.selincengiz.selin_cengiz_odev8.domain.repo.IRoomRepo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideRecipeRepo(recipesService: IRecipesService): IRecipesRepo =
        RecipesRepoImpl(recipesService = recipesService)

    @Provides
    @Singleton
    fun provideRoomRepo(recipeDao: IRecipeDao): IRoomRepo =
        RoomRepoImpl(recipeDao = recipeDao)

}