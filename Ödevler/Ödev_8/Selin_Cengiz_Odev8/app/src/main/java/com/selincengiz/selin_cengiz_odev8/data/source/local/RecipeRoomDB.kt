package com.selincengiz.selin_cengiz_odev8.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.selincengiz.selin_cengiz_odev8.data.entities.RecipeRoom

@Database(entities = [RecipeRoom::class], version = 1)
@TypeConverters(value = [MyTypeConverters::class])
abstract class RecipeRoomDB : RoomDatabase() {
    abstract fun recipeDao(): IRecipeDao
}