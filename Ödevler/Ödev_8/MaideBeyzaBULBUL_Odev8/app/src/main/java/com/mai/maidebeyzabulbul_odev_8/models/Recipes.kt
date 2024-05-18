package com.mai.maidebeyzabulbul_odev_8.models

import java.io.Serial
import java.io.Serializable

data class Recipes (
    val recipes: List<RecipeElement>,
    val total: Long,
    val skip: Long,
    val limit: Long
)

data class RecipeElement (
    val id: Long,
    val name: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val prepTimeMinutes: Long,
    val cookTimeMinutes: Long,
    val servings: Long,
    val difficulty: Difficulty,
    val cuisine: String,
    val caloriesPerServing: Long,
    val tags: List<String>,
    val userID: Long,
    val image: String,
    val rating: Double,
    val reviewCount: Long,
    val mealType: List<String>

) :Serializable

