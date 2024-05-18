package com.cevdetkilickeser.odev8

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.cevdetkilickeser.odev8.adapter.RecipeAdapter
import com.cevdetkilickeser.odev8.config.ApiClient
import com.cevdetkilickeser.odev8.databinding.ActivityMainBinding
import com.cevdetkilickeser.odev8.model.Recipe
import com.cevdetkilickeser.odev8.model.Recipes
import com.cevdetkilickeser.odev8.service.IDummyService
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var iDummyService: IDummyService
    lateinit var listViewRecipes: ListView
    lateinit var recipeAdapter: RecipeAdapter
    lateinit var recipeList: List<Recipe>
    lateinit var filteredList: MutableList<Recipe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listViewRecipes = binding.listView
        filteredList = mutableListOf()

        recipeAdapter = RecipeAdapter(this@MainActivity, filteredList)
        listViewRecipes.adapter = recipeAdapter

        getRecipesFromService()

        binding.btnSearch.setOnClickListener {
            val query = binding.txtSearch.text.toString()
            filterList(query)
        }
    }

    private fun getRecipesFromService() { // Sunucudan retrofit ile verileri çeker
        iDummyService = ApiClient.getClient().create(IDummyService::class.java)
        iDummyService.getRecipes().enqueue(object : Callback<Recipes> {
            override fun onResponse(p0: Call<Recipes>, p1: Response<Recipes>) {
                if (p1.isSuccessful) {
                    recipeList = p1.body()!!.recipes
                    filteredList.addAll(recipeList)
                    recipeAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(p0: Call<Recipes>, p1: Throwable) {
                Snackbar.make(listViewRecipes, p1.message.toString(), Snackbar.LENGTH_LONG).show()
            }
        })
    }

    private fun filterList(query: String) { // Searchbar'a yazılan arama kelimesi ile sunucudan çekilen veriler arasında filtreleme yapar
        filteredList.clear()
        if (query.isEmpty()) {
            filteredList.addAll(recipeList)
        } else {
            for (i in recipeList) {
                if (i.name.lowercase()
                        .contains(query)
                ) { // if parantezinde ( || i.tags.joinToString(" ").lowercase().contains(query)) kodu eklenerek, tags özelliği de filtreleme işlemine dahil edilebilir
                    filteredList.add(i)
                }
            }
        }
        recipeAdapter.notifyDataSetChanged()
    }
}