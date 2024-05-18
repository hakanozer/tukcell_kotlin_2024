package com.example.yunusemreceylan_odev8.data.model

import java.io.Serializable

data class Recipe(
    val id: Long = 0,
    val name: String? = null,
    val ingredients: List<String> = emptyList(),
    val instructions: List<String> = emptyList(),
    val prepTimeMinutes: Int = 0,
    val cookTimeMinutes: Int = 0,
    val servings: Int = 0,
    val difficulty: Difficulty = Difficulty.EASY,
    val cuisine: String? = null,
    val caloriesPerServing: Int = 0,
    val tags: List<String> = emptyList(),
    val userID: Long = 0,
    val image: String? = null,
    val rating: Float = 0.0f,
    val reviewCount: Int = 0,
    val mealType: List<String> = emptyList()
) : Serializable