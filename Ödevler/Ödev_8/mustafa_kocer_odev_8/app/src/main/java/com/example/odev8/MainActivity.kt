package com.example.odev8

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev8.adapters.RecipeListAdapter
import com.example.odev8.configs.ApiClient
import com.example.odev8.models.Recipe
import com.example.odev8.models.RecipeList
import com.example.odev8.services.IRecipeService
import com.google.android.material.search.SearchBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var listViewRecipe: ListView
    lateinit var arr : List<Recipe>
    private lateinit var txtSearch : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listViewRecipe = findViewById(R.id.listViewRecipe)
        txtSearch = findViewById(R.id.edtTxtSearch)
        val iRecipeService = ApiClient.getClient().create(IRecipeService::class.java)

        try {
            iRecipeService.getRecipes().enqueue(object : Callback<RecipeList>{
                override fun onResponse(p0: Call<RecipeList>, p1: Response<RecipeList>) {
                    println("onResponse }")
                    p1.body()?.let {
                        //println("veriler geldi ${it.recipes}")
                        arr = it.recipes
                        println(it.recipes)
                        val arrayAdapter = RecipeListAdapter(this@MainActivity, arr)
                        listViewRecipe.adapter = arrayAdapter
                    }

                }

                override fun onFailure(p0: Call<RecipeList>, p1: Throwable) {
                    println("onFailure! : ${p1.stackTrace}")

                }

            })

        }
        catch (ex : Exception){
            println("CATCH!!! Ex : ${ex.stackTrace}")
        }



        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Metin değişmeden önce yapılacak işlemler
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                // Metin değiştikçe yapılacak işlemler
                val text = txtSearch.text.toString()
                if (text.isNotBlank()){
                    // arama islemi burada yapilacak ve adapter yeniden atanip yeniden listeleyeceksin
                    val filteredArr = arr.filter { it.name.contains(text, ignoreCase = true) }
                    val arrayAdapter = RecipeListAdapter(this@MainActivity, filteredArr)
                    listViewRecipe.adapter = arrayAdapter
                }
                else{
                    val arrayAdapter = RecipeListAdapter(this@MainActivity, arr)
                    listViewRecipe.adapter = arrayAdapter
                }            }

        }

        txtSearch.addTextChangedListener(textWatcher)




    } // End of OnCreate



}