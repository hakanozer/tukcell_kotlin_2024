package com.selincengiz.selin_cengiz_odev8.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selincengiz.selin_cengiz_odev8.common.HomeState
import com.selincengiz.selin_cengiz_odev8.common.Resource
import com.selincengiz.selin_cengiz_odev8.data.mapper.mapToRecipeRoom
import com.selincengiz.selin_cengiz_odev8.domain.repo.IRecipesRepo
import com.selincengiz.selin_cengiz_odev8.domain.repo.IRoomRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val recipesRepoImpl: IRecipesRepo,
    private val recipesRoomImpl: IRoomRepo
) : ViewModel() {

    private var _homeState = MutableStateFlow<HomeState>(HomeState.Entry)
    val homeState: StateFlow<HomeState>
        get() = _homeState.asStateFlow()

    fun getRecipes() {
        viewModelScope.launch {
            _homeState.value = HomeState.Loading
            val result = recipesRepoImpl.getRecipes()

            when (result) {
                is Resource.Success -> {
                    result.data?.let { recipesRoomImpl.addRecipes(it) }
                    _homeState.value = HomeState.Recipes(result.data)
                }

                is Resource.Error -> {
                    _homeState.value = HomeState.Error(result.throwable)
                }
            }
        }
    }

    fun getRecipesByQuery(search: String) {
        viewModelScope.launch {
            _homeState.value = HomeState.Loading
            val result = recipesRoomImpl.getRecipesByQuery(search)
            when (result) {
                is Resource.Success -> {
                    _homeState.value = HomeState.Recipes(result.data)
                }

                is Resource.Error -> {
                    _homeState.value = HomeState.Error(result.throwable)
                }
            }
        }
    }

}