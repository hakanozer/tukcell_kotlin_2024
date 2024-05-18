package com.selincengiz.selin_cengiz_odev8.data.source.remote

import com.selincengiz.selin_cengiz_odev8.common.Constants.GET_RECIPES
import com.selincengiz.selin_cengiz_odev8.data.entities.ResponseRecipes
import retrofit2.http.GET
import retrofit2.http.Query

interface IRecipesService {
    @GET(GET_RECIPES)
    suspend fun getRecipes(): ResponseRecipes
}