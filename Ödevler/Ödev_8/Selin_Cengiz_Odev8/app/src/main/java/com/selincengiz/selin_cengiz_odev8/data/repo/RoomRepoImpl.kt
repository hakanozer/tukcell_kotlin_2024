package com.selincengiz.selin_cengiz_odev8.data.repo

import com.selincengiz.selin_cengiz_odev8.common.Resource
import com.selincengiz.selin_cengiz_odev8.data.mapper.mapToRecipeRoom
import com.selincengiz.selin_cengiz_odev8.data.mapper.mapToRecipeUI
import com.selincengiz.selin_cengiz_odev8.data.source.local.IRecipeDao
import com.selincengiz.selin_cengiz_odev8.domain.entities.RecipeUI
import com.selincengiz.selin_cengiz_odev8.domain.repo.IRoomRepo
import java.lang.Exception

class RoomRepoImpl(private val recipeDao: IRecipeDao) : IRoomRepo {
    override suspend fun getRecipesByQuery(search: String): Resource<List<RecipeUI>> {
        return try {
            Resource.Success(
                recipeDao.getRecipesByQuery(search).map { item -> item.mapToRecipeUI() }
            )
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override suspend fun addRecipes(recipe: List<RecipeUI>) {
        recipeDao.addRecipes(recipe.map { item -> item.mapToRecipeRoom() })
    }
}