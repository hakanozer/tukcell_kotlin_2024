package com.tlh.foodrecipe.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tlh.foodrecipe.model.Recipe

@Database (entities = [Recipe::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

}