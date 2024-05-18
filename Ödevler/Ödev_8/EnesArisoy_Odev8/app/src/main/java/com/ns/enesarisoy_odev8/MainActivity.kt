package com.ns.enesarisoy_odev8

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ns.enesarisoy_odev8.adapter.RecipeAdapter
import com.ns.enesarisoy_odev8.configs.ApiClient
import com.ns.enesarisoy_odev8.databinding.ActivityMainBinding
import com.ns.enesarisoy_odev8.model.RecipeResponse
import com.ns.enesarisoy_odev8.services.RecipeService
import com.ns.enesarisoy_odev8.util.hideKeyboard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recipeService: RecipeService
    private lateinit var binding: ActivityMainBinding
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getRecipes()
        binding.apply {

            etSearch.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if (s.isNullOrEmpty()) {
                        binding.tlSearch.startIconDrawable = ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.ic_search,
                            null
                        )
                    } else {
                        tlSearch.startIconDrawable = ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.baseline_close_24,
                            null
                        )
                        tlSearch.setStartIconOnClickListener {
                            etSearch.text?.clear()
                            etSearch.clearFocus()
                            it.hideKeyboard()
                        }
                    }
                    val searchText = s.toString().lowercase().trim()
                    searchRecipe(searchText)
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
        }

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val selectedRecipe = recipeAdapter.getItem(position)

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("recipeId", selectedRecipe?.id)
            startActivity(intent)
            println(selectedRecipe?.name)
        }


    }

    private fun searchRecipe(searchText: String) {
        recipeService = ApiClient.getClient().create(RecipeService::class.java)

        recipeService.searchRecipes(searchText).enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(
                call: Call<RecipeResponse>,
                response: Response<RecipeResponse>
            ) {
                if (response.isSuccessful) {
                    val recipeResponse = response.body()
                    recipeAdapter =
                        RecipeAdapter(this@MainActivity, recipeResponse?.recipes ?: emptyList())
                    binding.listView.adapter = recipeAdapter
                    Log.d("MainActivity", "onResponse: $recipeResponse")
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Log.e("MainActivity", "onFailure: ${t.message}")
            }
        })
    }

    private fun getRecipes() {
        recipeService = ApiClient.getClient().create(RecipeService::class.java)
        recipeService.getRecipes().enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(
                call: Call<RecipeResponse>,
                response: Response<RecipeResponse>
            ) {
                if (response.isSuccessful) {
                    val recipeResponse = response.body()
                    recipeAdapter =
                        RecipeAdapter(this@MainActivity, recipeResponse?.recipes ?: emptyList())
                    binding.listView.adapter = recipeAdapter
                    Log.d("MainActivity", "onResponse: $recipeResponse")
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Log.e("MainActivity", "onFailure: ${t.message}")
            }
        })
    }
}