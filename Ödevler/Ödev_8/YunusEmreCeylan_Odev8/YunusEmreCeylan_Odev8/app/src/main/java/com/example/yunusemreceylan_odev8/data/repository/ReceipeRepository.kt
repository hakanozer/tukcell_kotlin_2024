package com.example.yunusemreceylan_odev8.data.repository

import com.example.yunusemreceylan_odev8.data.api.ApiClient
import com.example.yunusemreceylan_odev8.data.api.IDummyService
import com.example.yunusemreceylan_odev8.data.model.Recipe
import com.example.yunusemreceylan_odev8.data.model.Recipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeRepository {
    private val dummyService: IDummyService = ApiClient.getClient().create(IDummyService::class.java)

    fun fetchRecipes(searchQuery: String, onResult: (List<Recipe>?) -> Unit) {
        dummyService.getRecipe(searchQuery).enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                if (response.isSuccessful) {
                    onResult(response.body()?.recipes)
                } else {
                    onResult(null)
                }
            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                onResult(null)
            }
        })
    }
}
