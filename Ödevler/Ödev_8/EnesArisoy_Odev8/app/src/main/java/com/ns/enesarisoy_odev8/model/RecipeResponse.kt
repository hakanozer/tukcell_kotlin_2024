package com.ns.enesarisoy_odev8.model

data class RecipeResponse(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)