package com.example.eray_altilar_odev_8

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eray_altilar_odev_8.adapters.RecipeAdaptor
import com.example.eray_altilar_odev_8.configs.ApiClient
import com.example.eray_altilar_odev_8.databinding.ActivityMainBinding
import com.example.eray_altilar_odev_8.model.Recipe
import com.example.eray_altilar_odev_8.model.Recipes
import com.example.eray_altilar_odev_8.services.IService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var service: IService
    private lateinit var recipeAdaptor: RecipeAdaptor
    private var recipeList: List<Recipe> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        service = ApiClient.getClient().create(IService::class.java)

        val listViewRecipe = binding.listViewRecipe
        val editTextSearch = binding.editTextSearch
        val btnSearch = binding.btnSearch


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        service.getRecipes().enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                if (response.isSuccessful) {
                    recipeList = response.body()!!.recipes
                    recipeAdaptor = RecipeAdaptor(this@MainActivity, recipeList)
                    listViewRecipe.adapter = recipeAdaptor
                }
            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                Log.e("RecipeListError", t.message!!)
            }
        })

        btnSearch.setOnClickListener {
            val searchText = editTextSearch.text.toString()
            search(searchText)
        }
    }

    private fun search(text: String) {
        val filteredList = recipeList.filter {
            it.name.contains(text, ignoreCase = true)
        }
        val updateList = RecipeAdaptor(this@MainActivity, filteredList)
        binding.listViewRecipe.adapter = updateList
    }
}
