package com.selincengiz.selin_cengiz_odev8.common


import com.selincengiz.selin_cengiz_odev8.domain.entities.RecipeUI


sealed interface HomeState {
    object Entry : HomeState
    object Loading : HomeState
    data class Recipes(val list: List<RecipeUI>?) : HomeState
    data class Error(val throwable: Throwable) : HomeState
}