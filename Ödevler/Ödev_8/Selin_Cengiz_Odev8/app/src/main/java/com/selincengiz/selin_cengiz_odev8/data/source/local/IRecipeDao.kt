package com.selincengiz.selin_cengiz_odev8.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.selincengiz.selin_cengiz_odev8.data.entities.RecipeRoom

@Dao
interface IRecipeDao {

    @Query("SELECT * FROM recipes  WHERE  name LIKE '%' || :search || '%'")
    suspend fun getRecipesByQuery(search: String): List<RecipeRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecipes(recipe: List<RecipeRoom>)

}