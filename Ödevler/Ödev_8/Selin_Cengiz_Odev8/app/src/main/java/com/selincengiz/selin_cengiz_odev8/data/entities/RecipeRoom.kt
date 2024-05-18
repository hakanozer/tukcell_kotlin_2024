package com.selincengiz.selin_cengiz_odev8.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeRoom(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int?,
    @ColumnInfo("caloriesPerServing")
    val caloriesPerServing: Int?,
    @ColumnInfo("cookTimeMinutes")
    val cookTimeMinutes: Int?,
    @ColumnInfo("cuisine")
    val cuisine: String?,
    @ColumnInfo("difficulty")
    val difficulty: String?,
    @ColumnInfo("image")
    val image: String?,
    @ColumnInfo("ingredients")
    val ingredients: List<String>?,
    @ColumnInfo("instructions")
    val instructions: List<String>?,
    @ColumnInfo("mealType")
    val mealType: List<String>?,
    @ColumnInfo("name")
    val name: String?,
    @ColumnInfo("prepTimeMinutes")
    val prepTimeMinutes: Int?,
    @ColumnInfo("rating")
    val rating: Double?,
    @ColumnInfo("reviewCount")
    val reviewCount: Int?,
    @ColumnInfo("servings")
    val servings: Int?,
    @ColumnInfo("tags")
    val tags: List<String>?,
    @ColumnInfo("userId")
    val userId: Int?
)
