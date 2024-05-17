package com.tlh.recipes.model

data class Recipe(
    val id: Int,
    val name: String,
    val caloriesPerServing: Int,
    val ingredients: List<String>,
    val instructions: List<String>,
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val servings: Int,
    val difficulty: String,
    val cuisine: String,
    val tags: List<String>,
    val userId: Int,
    val image: String,
    val rating: Float,
    val reviewCount: Int,
    val mealType: List<String>
)

data class RecipeResponse(
    val recipes: List<Recipe>
)

