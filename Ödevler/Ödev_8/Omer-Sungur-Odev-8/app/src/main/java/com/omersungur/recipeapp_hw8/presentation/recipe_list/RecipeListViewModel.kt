package com.omersungur.recipeapp_hw8.presentation.recipe_list

import androidx.lifecycle.ViewModel
import com.omersungur.recipeapp_hw8.domain.model.RecipeResult
import com.omersungur.recipeapp_hw8.domain.repository.RecipeRepository
import com.omersungur.recipeapp_hw8.domain.usecase.GetRecipesUseCase
import com.omersungur.recipeapp_hw8.domain.usecase.RecipeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    recipeUseCases: RecipeUseCases,
) : ViewModel() {

    val recipe = recipeUseCases.getRecipeUseCase()
    private var filteredRecipeList = emptyList<RecipeResult>()

    fun filterRecipe(query: String, recipeList: List<RecipeResult>): List<RecipeResult> {
        filteredRecipeList = recipeList.filter {
            it.name.contains(query, ignoreCase = true)
        }
        return filteredRecipeList
    }
}