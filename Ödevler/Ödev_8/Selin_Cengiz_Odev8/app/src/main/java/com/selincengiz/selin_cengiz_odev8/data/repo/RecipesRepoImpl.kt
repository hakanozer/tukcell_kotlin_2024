package com.selincengiz.selin_cengiz_odev8.data.repo

import com.selincengiz.selin_cengiz_odev8.common.Resource
import com.selincengiz.selin_cengiz_odev8.data.mapper.mapToRecipeUI
import com.selincengiz.selin_cengiz_odev8.data.source.remote.IRecipesService
import com.selincengiz.selin_cengiz_odev8.domain.entities.RecipeUI
import com.selincengiz.selin_cengiz_odev8.domain.repo.IRecipesRepo
import java.lang.Exception

class RecipesRepoImpl(private val recipesService: IRecipesService) : IRecipesRepo {
    override suspend fun getRecipes(): Resource<List<RecipeUI>> {
        return try {
            Resource.Success(recipesService.getRecipes().recipes?.map { item ->
                item.mapToRecipeUI()
            })
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}