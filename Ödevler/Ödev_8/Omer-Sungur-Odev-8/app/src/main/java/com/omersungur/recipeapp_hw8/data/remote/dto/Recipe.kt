package com.omersungur.recipeapp_hw8.data.remote.dto

data class Recipe(
    val limit: Int,
    val recipes: List<RecipeX>,
    val skip: Int,
    val total: Int
)