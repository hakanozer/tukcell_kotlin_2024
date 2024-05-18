package com.example.myapplication

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Recipe
import com.example.myapplication.model.Recipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


            binding.btnSearch.setOnClickListener {
                val quers = binding.Searchbuttn.text.toString()
                val filtrecs = fullRecipeList.filter {
                    it.name.contains(query, ignoreCase = true)
                }

                updateListView(filteredRecipes)




            }






            dummyService = ApiClient.getClient().create(DummyService::class.java)
            dummyService.getProducts().enqueue(object : Callback<Recipes> {
                override fun onResponse(p0: Call<Recipes>, p1: Response<Recipes>) {
                    if (p1.isSuccessful) {
                        filtrecs = p1.body()!!.recipes
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
    }}