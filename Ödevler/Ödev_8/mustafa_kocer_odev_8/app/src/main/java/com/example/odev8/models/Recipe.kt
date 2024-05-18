package com.example.odev8.models

import java.io.Serializable

data class Recipe(
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val servings: Int,
    val difficulty: String,
    val cuisine: String,
    val caloriesPerServing: Int,
    val tags: List<String>,
    val userId: Int,
    val image: String,
    val rating: Double,
    val reviewCount: Int,
    val mealType: List<String>
) : Serializable

data class RecipeList(
    val recipes: List<Recipe>,
    val total: Int,
    val skip: Int,
    val limit: Int
) : Serializable

