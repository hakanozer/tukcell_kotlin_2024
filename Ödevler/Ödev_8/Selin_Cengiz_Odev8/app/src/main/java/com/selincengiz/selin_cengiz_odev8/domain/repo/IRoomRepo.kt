package com.selincengiz.selin_cengiz_odev8.domain.repo

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.selincengiz.selin_cengiz_odev8.common.Resource
import com.selincengiz.selin_cengiz_odev8.data.entities.RecipeRoom
import com.selincengiz.selin_cengiz_odev8.domain.entities.RecipeUI

interface IRoomRepo {
    suspend fun getRecipesByQuery(search: String): Resource<List<RecipeUI>>

    suspend fun addRecipes(recipe: List<RecipeUI>)
}