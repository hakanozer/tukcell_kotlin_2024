package com.tlh.foodrecipe.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @ColumnInfo(name = "recipe_name") val recipeName: String,
    @ColumnInfo(name = "recipe_ingredients") val recipeIngredients: String,
    @ColumnInfo(name = "recipe_image") val recipeImage: ByteArray
) {
    @PrimaryKey(autoGenerate = true)
    var rid: Int = 0
}