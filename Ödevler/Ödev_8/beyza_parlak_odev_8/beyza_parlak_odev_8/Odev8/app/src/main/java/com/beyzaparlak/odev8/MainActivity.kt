package com.beyzaparlak.odev8

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.beyzaparlak.odev8.adaptors.RecipeAdaptors
import com.beyzaparlak.odev8.configs.ApiClient
import com.beyzaparlak.odev8.databinding.ActivityMainBinding
import com.beyzaparlak.odev8.models.Recipe
import com.beyzaparlak.odev8.models.Recipes
import com.beyzaparlak.odev8.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var dummyService: IDummyService
    private var fullRecipeList: List<Recipe> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // search butona tıklandığında
        binding.btnSearch.setOnClickListener {
            val rQuery = binding.txtSearch.text.toString()
            val filter = fullRecipeList.filter {
                it.name.contains(rQuery, ignoreCase = true)
            }

            // search butona basıldıktan sonraki listView
            updateListViewRecipes(filter)
        }

        // servis işlemleri
        dummyService = ApiClient.getClient().create(IDummyService::class.java)
        dummyService.getProducts().enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, rs: Response<Recipes>) {
                if (rs.isSuccessful) {
                    fullRecipeList = rs.body()!!.recipes
                    updateListViewRecipes(fullRecipeList)
                }
            }
            override fun onFailure(call: Call<Recipes>, th: Throwable) {
                Log.e("recipes", th.message!! )
            }
        })
    }

    // yeni listView -> filter işlemi sonrası
    fun updateListViewRecipes(recipes: List<Recipe>) {
        val productAdaptors = RecipeAdaptors(this@MainActivity, recipes)
        binding.listViewRecipes.adapter = productAdaptors
    }

}