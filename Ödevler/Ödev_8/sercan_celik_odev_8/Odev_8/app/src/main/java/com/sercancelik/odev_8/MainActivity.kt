package com.sercancelik.odev_8

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.sercancelik.odev_8.adaptors.RecipesAdaptors
import com.sercancelik.odev_8.configs.ApiClient
import com.sercancelik.odev_8.databinding.ActivityMainBinding
import com.sercancelik.odev_8.models.Recipe
import com.sercancelik.odev_8.models.Recipes
import com.sercancelik.odev_8.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dummyService: DummyService
    lateinit var searchView: SearchView
    lateinit var recipeAdaptors: RecipesAdaptors
    lateinit var progressBar: ProgressBar
    lateinit var swipetorefresh: androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    var recipeList = mutableListOf<Recipe>()
    var newListOfRecipes = mutableListOf<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        fetchAndDisplayRecipes()
        newListOfRecipes = addToListAndReturnNewList(recipeList)
        progressBar = binding.progressBar
        swipetorefresh = binding.swipeToRefresh
        searchView = binding.searchView
        search(newListOfRecipes)
        swipetorefresh.setOnRefreshListener {
            fetchAndDisplayRecipes()
            swipetorefresh.isRefreshing = false
            binding.searchView.setQuery("", false)
        }


    }

    private fun fetchAndDisplayRecipes() {
        dummyService.getRecipes().enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val arr = response.body()!!.recipes
                    recipeList.clear()
                    addToListAndReturnNewList(arr)
                    recipeAdaptors = RecipesAdaptors(this@MainActivity, arr)
                    binding.listViewRecipes.adapter = recipeAdaptors
                }
            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                Log.e("API_ERROR", "Failed to fetch recipe: ${t.message}")
            }
        })
    }

    fun search(recipes: List<Recipe>) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredRecipes =
                    recipes.filter { it.name.contains(newText ?: "", ignoreCase = true) }
                recipeAdaptors.clear()
                recipeAdaptors.addAll(filteredRecipes)
                return false
            }
        })
    }


    fun addToListAndReturnNewList(recipes: List<Recipe>): MutableList<Recipe> {
        recipeList.addAll(recipes)
        return recipeList
    }

}


