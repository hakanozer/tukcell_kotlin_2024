package com.selincengiz.selin_cengiz_odev8.domain.repo

import com.selincengiz.selin_cengiz_odev8.common.Resource
import com.selincengiz.selin_cengiz_odev8.data.entities.Recipe
import com.selincengiz.selin_cengiz_odev8.domain.entities.RecipeUI

interface IRecipesRepo {
    suspend fun getRecipes(): Resource<List<RecipeUI>>
}