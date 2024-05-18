package com.mai.maidebeyzabulbul_odev_8

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.mai.days8.configs.ApiClient
import com.mai.maidebeyzabulbul_odev_8.Adapter.RecipeAdapter
import com.mai.maidebeyzabulbul_odev_8.models.Recipes
import com.mai.maidebeyzabulbul_odev_8.service.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecipeAdapter
    private lateinit var recipeService: IDummyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recipeService = ApiClient.getClient().create(IDummyService::class.java)

        adapter = RecipeAdapter(this, ArrayList())

        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val recipe = adapter.getItem(position)
            val intent = Intent(this, RecipeDetailActivity::class.java).apply {
                putExtra("RECIPE", recipe)
            }
            startActivity(intent)
        }
        val searchButton: Button = findViewById(R.id.searchButton)
        val searchEditText: EditText = findViewById(R.id.searchEditText)
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            if (query.isNotEmpty()) {
                searchRecipes(query)
            } else {
                loadAllRecipes()
            }
        }

        loadAllRecipes()
    }

    private fun loadAllRecipes() {
        recipeService.getRecipes().enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                response.body()?.let {
                    adapter.updateRecipes(it.recipes)
                }
            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                // Hata işlemleri
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun searchRecipes(query: String) {
        recipeService.searchRecipes(query).enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                response.body()?.let {
                    adapter.updateRecipes(it.recipes)
                }
            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                // Hata işlemleri
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}



