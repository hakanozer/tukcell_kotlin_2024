package com.omersungur.recipeapp_hw8.domain.model

import java.io.Serializable

data class RecipeModel(
    val limit: Int,
    val recipes: List<RecipeResult>,
    val skip: Int,
    val total: Int
): Serializable