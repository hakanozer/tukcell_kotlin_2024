package com.example.yunusemreceylan_odev8.domain.usecase

import com.example.yunusemreceylan_odev8.data.model.Recipe
import com.example.yunusemreceylan_odev8.data.repository.RecipeRepository

class FetchRecipesUseCase(private val repository: RecipeRepository) {

    fun execute(searchQuery: String, onResult: (List<Recipe>?) -> Unit) {
        repository.fetchRecipes(searchQuery) { recipes ->
            onResult(recipes)
        }
    }
}
