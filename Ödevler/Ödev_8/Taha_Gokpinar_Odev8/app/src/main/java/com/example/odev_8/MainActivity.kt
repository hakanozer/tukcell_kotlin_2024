package com.example.odev_8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev_8.adaptors.RecipeAdaptors
import com.example.odev_8.configs.ApiClient
import com.example.odev_8.databinding.ActivityMainBinding
import com.example.odev_8.models.Recipe
import com.example.odev_8.models.Recipes
import com.example.odev_8.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var dummyService: DummyService
    lateinit var arr: List<Recipe>
    lateinit var recipeAdaptors: RecipeAdaptors


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.getRecipes().enqueue(object : Callback<Recipes> {
            override fun onResponse(p0: Call<Recipes>, p1: Response<Recipes>) {
                if (p1.isSuccessful) {
                    arr = p1.body()!!.recipes
                    recipeAdaptors = RecipeAdaptors(this@MainActivity, arr)
                    binding.listViewRecipes.adapter = recipeAdaptors
                }
            }

            override fun onFailure(p0: Call<Recipes>, p1: Throwable) {
                Log.e("getRecipes", p1.message!!)
            }
        })


        binding.btnSearch.setOnClickListener {
            val searchResult = mutableListOf<Recipe>()
            val searchText = binding.editTextSearch.text.toString().lowercase()
            if(arr.isNotEmpty()){
                for (it in arr){
                    if (it.name.lowercase().contains(searchText)){
                        searchResult.add(it)
                    }
                }
            }
            recipeAdaptors = RecipeAdaptors(this@MainActivity, searchResult)
            binding.listViewRecipes.adapter = recipeAdaptors
        }

        binding.listViewRecipes.setOnItemClickListener { parent, view, position, id ->
            if(arr.isNotEmpty()){
                val selectedRecipe = recipeAdaptors.getItem(position) as Recipe
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("recipe", selectedRecipe)
                startActivity(intent)
            }
        }

    }
}