package com.omersungur.recipeapp_hw8.data.repository

import com.omersungur.recipeapp_hw8.core.Resource
import com.omersungur.recipeapp_hw8.data.mapper.recipeModel
import com.omersungur.recipeapp_hw8.data.remote.RecipeApi
import com.omersungur.recipeapp_hw8.domain.model.RecipeModel
import com.omersungur.recipeapp_hw8.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeApi: RecipeApi
) : RecipeRepository {

    override fun getRecipes(): Flow<Resource<RecipeModel>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val recipes = recipeApi.getRecipes()
            emit(Resource.Success(recipes.recipeModel()))
        }
    }
}