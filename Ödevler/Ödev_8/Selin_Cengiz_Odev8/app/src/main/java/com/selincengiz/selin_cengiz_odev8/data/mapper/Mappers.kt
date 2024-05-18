package com.selincengiz.selin_cengiz_odev8.data.mapper

import com.selincengiz.selin_cengiz_odev8.data.entities.Recipe
import com.selincengiz.selin_cengiz_odev8.data.entities.RecipeRoom
import com.selincengiz.selin_cengiz_odev8.domain.entities.RecipeUI

fun Recipe.mapToRecipeUI(): RecipeUI {
    return RecipeUI(
        id,
        caloriesPerServing,
        cookTimeMinutes,
        cuisine,
        difficulty,
        image,
        ingredients,
        instructions,
        mealType,
        name,
        prepTimeMinutes,
        rating,
        reviewCount,
        servings,
        tags,
        userId
    )
}

fun RecipeRoom.mapToRecipeUI(): RecipeUI {
    return RecipeUI(
        id,
        caloriesPerServing,
        cookTimeMinutes,
        cuisine,
        difficulty,
        image,
        ingredients,
        instructions,
        mealType,
        name,
        prepTimeMinutes,
        rating,
        reviewCount,
        servings,
        tags,
        userId
    )
}

fun RecipeUI.mapToRecipeRoom(): RecipeRoom {
    return RecipeRoom(
        id,
        caloriesPerServing,
        cookTimeMinutes,
        cuisine,
        difficulty,
        image,
        ingredients,
        instructions,
        mealType,
        name,
        prepTimeMinutes,
        rating,
        reviewCount,
        servings,
        tags,
        userId
    )
}