package com.toren.odev8.model

data class RecipesDto(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)