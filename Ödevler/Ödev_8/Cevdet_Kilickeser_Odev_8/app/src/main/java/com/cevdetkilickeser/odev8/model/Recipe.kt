package com.cevdetkilickeser.odev8.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Recipe(
    @SerializedName("caloriesPerServing") val caloriesPerServing: Int,
    @SerializedName("cookTimeMinutes") val cookTimeMinutes: Int,
    @SerializedName("cuisine") val cuisine: String,
    @SerializedName("difficulty") val difficulty: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("ingredients") val ingredients: List<String>,
    @SerializedName("instructions") val instructions: List<String>,
    @SerializedName("mealType") val mealType: List<String>,
    @SerializedName("name") val name: String,
    @SerializedName("prepTimeMinutes") val prepTimeMinutes: Int,
    @SerializedName("rating") val rating: Double,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("servings") val servings: Int,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("userId") val userId: Int
) : Serializable