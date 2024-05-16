package com.canerdedeoglu.odev_8

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
import com.canerdedeoglu.odev_8.adaptors.RecipeAdaptors
import com.canerdedeoglu.odev_8.configs.ApiClient
import com.canerdedeoglu.odev_8.model.Recipes
import com.canerdedeoglu.odev_8.service.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var dummyService: IDummyService
    lateinit var txtSearch: EditText
    lateinit var btnSearch: Button
    lateinit var listViewRecipes: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtSearch = findViewById(R.id.txtSearch)
        btnSearch = findViewById(R.id.btnSearch)
        listViewRecipes = findViewById(R.id.listViewRecipes)
        dummyService = ApiClient.getClient().create(IDummyService::class.java)

        // İlk yükleme
        verileriYükle("")

        btnSearch.setOnClickListener {
            val searchQuery = txtSearch.text.toString().trim()
            // Arama butonu işlemi
            if (searchQuery.isNotEmpty()) {
                verileriYükle(searchQuery)
            } else {
                Toast.makeText(this, "Lütfen arama yapmak için bir kelime girin", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verileriYükle(searchQuery: String) {

        dummyService.getRecipe(searchQuery).enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                // Response succes ise
                if (response.isSuccessful) {
                    val array = response.body()?.recipes
                    // Array null ya da boş değil ise
                    if (array != null && array.isNotEmpty()) {
                        val recipesAdaptors = RecipeAdaptors(this@MainActivity, array)
                        listViewRecipes.adapter = recipesAdaptors

                    } else {
                        Toast.makeText(this@MainActivity, "Recipes bulunamadı", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Search failed: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                Log.e("Search", "Search error: ${t.message}")
                Toast.makeText(this@MainActivity, "Search error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
