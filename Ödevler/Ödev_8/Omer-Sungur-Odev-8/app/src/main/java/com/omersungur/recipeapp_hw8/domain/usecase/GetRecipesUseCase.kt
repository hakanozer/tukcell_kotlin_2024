package com.omersungur.recipeapp_hw8.domain.usecase

import com.omersungur.recipeapp_hw8.core.Resource
import com.omersungur.recipeapp_hw8.domain.model.RecipeModel
import com.omersungur.recipeapp_hw8.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow

class GetRecipesUseCase(
    private val recipeRepository: RecipeRepository,
) {

    operator fun invoke(): Flow<Resource<RecipeModel>> {
        return recipeRepository.getRecipes()
    }
}