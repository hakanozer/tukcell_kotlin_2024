package com.omersungur.recipeapp_hw8.domain.repository

import com.omersungur.recipeapp_hw8.core.Resource
import com.omersungur.recipeapp_hw8.domain.model.RecipeModel
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipes(): Flow<Resource<RecipeModel>>
}