package com.example.odev8

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.odev8.adaptors.RecipeAdaptors
import com.example.odev8.configs.ApiClient
import com.example.odev8.databinding.ActivityMainBinding
import com.example.odev8.models.Recipe
import com.example.odev8.models.Recipes
import com.example.odev8.services.DummyService


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var dummyService: DummyService
    private var fullRecipeList: List<Recipe> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            val query = binding.editTextSearch.text.toString()
            val filteredRecipes = fullRecipeList.filter {
                it.name.contains(query, ignoreCase = true)
            }

            updateListView(filteredRecipes)




        }






        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.getProducts().enqueue(object : Callback<Recipes> {
            override fun onResponse(p0: Call<Recipes>, p1: Response<Recipes>) {
                if (p1.isSuccessful) {
                    fullRecipeList = p1.body()!!.recipes
                   updateListView(fullRecipeList)

                }
            }

            override fun onFailure(p0: Call<Recipes>, p1: Throwable) {
                Log.e("getRecipes", p1.message!! )
            }
        } )


    }
    fun updateListView(recipes: List<Recipe>) {
        val productAdaptors = RecipeAdaptors(this@MainActivity, recipes)
        binding.listViewRecipes.adapter = productAdaptors
    }
}