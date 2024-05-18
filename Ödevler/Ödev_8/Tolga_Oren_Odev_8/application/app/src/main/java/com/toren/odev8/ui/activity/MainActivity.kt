package com.toren.odev8.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.toren.odev8.R
import com.toren.odev8.model.Recipe
import com.toren.odev8.client.RecipeClient
import com.toren.odev8.service.RecipeService
import com.toren.odev8.ui.adapter.RecipesAdapter
import com.toren.odev8.model.RecipesDto
import com.toren.odev8.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecipesAdapter
    lateinit var allRecipes: List<Recipe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecipesAdapter(this, mutableListOf())
        binding.recipesListView.adapter = adapter

        binding.mainToolbar.toolbar.inflateMenu(R.menu.search_item)
        val searchItem = binding.mainToolbar.toolbar.menu.findItem(R.id.search_action)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val filteredList = allRecipes.filter {
                    it.name.lowercase().contains(query.toString())
                }
                adapter.updateRecipes(filteredList)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = allRecipes.filter {
                    it.name.lowercase().contains(newText.toString())
                }
                adapter.updateRecipes(filteredList)
                if (newText?.length == 0) {
                    adapter.updateRecipes(allRecipes)
                }
                return true
            }

        })

        val client = RecipeClient.getClient().create(RecipeService::class.java)
        client.getRecipes().enqueue(object : Callback<RecipesDto> {
            override fun onResponse(p0: Call<RecipesDto>, p1: Response<RecipesDto>) {
                p1.body()?.let {
                    allRecipes = it.recipes
                    adapter.updateRecipes(it.recipes)
                }
            }

            override fun onFailure(p0: Call<RecipesDto>, p1: Throwable) {
                Log.e("getData", "Error")
            }
        })


    }
}