package com.example.yusuf_mucahit_solmaz_odev_8

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yusuf_mucahit_solmaz_odev_8.adapter.RecipeListAdapter
import com.example.yusuf_mucahit_solmaz_odev_8.data.model.Recipe
import com.example.yusuf_mucahit_solmaz_odev_8.data.model.RootReciepe
import com.example.yusuf_mucahit_solmaz_odev_8.databinding.ActivityMainBinding
import com.example.yusuf_mucahit_solmaz_odev_8.repository.serviceImp.RecipeServiceImp

class MainActivity : AppCompatActivity() {
    private lateinit var recipeService: RecipeServiceImp
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecipeListAdapter
    private var allRecipes: List<Recipe> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recipeService = RecipeServiceImp()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recipeService.getAllRecipe()

        recipeService.recipeList.observe(this) { recipeList ->
            allRecipes = recipeList.recipes
            adapter = RecipeListAdapter(this, allRecipes)
            binding.listView.adapter = adapter
        }

        setupSearchView()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = if (newText.isNullOrEmpty()) {
                    allRecipes
                } else {
                    allRecipes.filter { it.name.contains(newText, ignoreCase = true) }
                }
                adapter = RecipeListAdapter(this@MainActivity, filteredList)
                binding.listView.adapter = adapter
                return true
            }
        })
    }
}
