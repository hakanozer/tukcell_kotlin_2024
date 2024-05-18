package com.example.yunusemreceylan_odev8.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yunusemreceylan_odev8.data.model.Recipe
import com.example.yunusemreceylan_odev8.data.repository.RecipeRepository
import com.example.yunusemreceylan_odev8.domain.usecase.FetchRecipesUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    val recipesLiveData: MutableLiveData<List<Recipe>?> = MutableLiveData()
    private val repository = RecipeRepository()
    private val fetchRecipesUseCase = FetchRecipesUseCase(repository)

    init {
        fetchRecipes("")
    }

    fun fetchRecipes(searchQuery: String) {
        viewModelScope.launch {
            fetchRecipesUseCase.execute(searchQuery) { recipes ->
                recipesLiveData.postValue(recipes)
            }
        }
    }

    fun setRecipes(recipes: List<Recipe>) {
        recipesLiveData.value = recipes
    }
}
