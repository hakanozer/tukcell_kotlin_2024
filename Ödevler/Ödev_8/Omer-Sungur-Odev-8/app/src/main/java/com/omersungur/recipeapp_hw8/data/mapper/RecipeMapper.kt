package com.omersungur.recipeapp_hw8.data.mapper

import com.omersungur.recipeapp_hw8.data.remote.dto.Recipe
import com.omersungur.recipeapp_hw8.data.remote.dto.RecipeX
import com.omersungur.recipeapp_hw8.domain.model.RecipeModel
import com.omersungur.recipeapp_hw8.domain.model.RecipeResult

fun Recipe.recipeModel(): RecipeModel {
    return RecipeModel(
        limit = limit,
        recipes = recipes.map { it.toRecipeResult() },
        skip = skip,
        total = total
    )
}

fun RecipeX.toRecipeResult(): RecipeResult {
    return RecipeResult(
        caloriesPerServing = caloriesPerServing,
        cookTimeMinutes = cookTimeMinutes,
        cuisine = cuisine,
        difficulty = difficulty,
        id = id,
        image = image,
        ingredients = ingredients,
        instructions = instructions,
        mealType = mealType,
        name = name,
        prepTimeMinutes = prepTimeMinutes,
        rating = rating,
        reviewCount = reviewCount,
        servings = servings,
        tags = tags,
        userId = userId
    )
}