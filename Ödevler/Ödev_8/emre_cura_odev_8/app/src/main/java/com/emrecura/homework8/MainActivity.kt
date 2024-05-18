package com.emrecura.homework8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.emrecura.homework8.adaptors.RecipeAdaptors
import com.emrecura.homework8.configs.ApiClient
import com.emrecura.homework8.models.Recipe
import com.emrecura.homework8.models.Recipes
import com.emrecura.homework8.services.RecipeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recipeService: RecipeService
    lateinit var listViewRecipes: ListView
    lateinit var arr: List<Recipe>
    private lateinit var searchBar: EditText
    private lateinit var searchButton: Button
    private lateinit var recipeAdaptors: RecipeAdaptors

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        searchBar = findViewById(R.id.searchBar)
        searchButton = findViewById(R.id.searchButton)
        listViewRecipes = findViewById(R.id.listViewRecipes)

        recipeService = ApiClient.getClient().create(RecipeService::class.java)

        getRecipes()

        listViewRecipes.setOnItemClickListener { adapterView, view, i, l ->
            val selectedRecipe = arr[i]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("selectedRecipe", selectedRecipe)
            startActivity(intent)
        }


        searchButton.setOnClickListener {
            val query = searchBar.text.toString().trim()
            if (query.isNotEmpty()) {
                searchRecipes(query)
            } else {
                Toast.makeText(this, "Bir yemek adı girin!", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun getRecipes() {
        recipeService.getRecipes().enqueue(object : Callback<Recipes> {
            override fun onResponse(p0: Call<Recipes>, p1: Response<Recipes>) {
                arr = p1.body()!!.recipes
                recipeAdaptors = RecipeAdaptors(this@MainActivity, arr)
                listViewRecipes.adapter = recipeAdaptors
            }

            override fun onFailure(p0: Call<Recipes>, p1: Throwable) {
                Log.e("getProducts", p1.message!!)
            }
        })
    }

    private fun searchRecipes(query: String) {
        val call = recipeService.searchRecipes(query)
        call.enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                if (response.isSuccessful) {
                    arr = response.body()?.recipes ?: listOf()
                    recipeAdaptors = RecipeAdaptors(this@MainActivity, arr)
                    listViewRecipes.adapter = recipeAdaptors
                } else {
                    Log.e("searchRecipes", "Response unsuccessful")
                }
            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                Log.e("searchRecipes", t.message ?: "Unknown error")
            }
        })
    }
}