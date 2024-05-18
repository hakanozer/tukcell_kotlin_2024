package com.selincengiz.selin_cengiz_odev8.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeUI(
    val id: Int?,
    val caloriesPerServing: Int?,
    val cookTimeMinutes: Int?,
    val cuisine: String?,
    val difficulty: String?,
    val image: String?,
    val ingredients: List<String>?,
    val instructions: List<String>?,
    val mealType: List<String>?,
    val name: String?,
    val prepTimeMinutes: Int?,
    val rating: Double?,
    val reviewCount: Int?,
    val servings: Int?,
    val tags: List<String>?,
    val userId: Int?
) : Parcelable