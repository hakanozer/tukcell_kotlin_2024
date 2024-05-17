package com.tlh.classicrecipe


import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.tlh.classicrecipe.adapters.RecipeAdapter
import com.tlh.classicrecipe.config.ApiClient
import com.tlh.classicrecipe.model.Recipes
import com.tlh.classicrecipe.service.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var dummyService: IDummyService
    private lateinit var searchText: TextView
    private lateinit var searchButton: Button
    private lateinit var listView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        dummyService = ApiClient.getClient().create(IDummyService::class.java)
        searchText = findViewById(R.id.txtSearch)
        searchButton = findViewById(R.id.btnSearch)
        listView = findViewById(R.id.listView)


        loadRows("")

        searchButton.setOnClickListener {
            val userQuery = searchText.text.toString()
            if (userQuery.isNotEmpty()) {
                loadRows(userQuery)
            } else {
                Toast.makeText(this, "Please enter a search term", Toast.LENGTH_SHORT)
                    .show()
            }

        }


    }

    private infix fun loadRows(userQuery: String) {

        dummyService.getRecipe(userQuery).enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                if (response.isSuccessful) {
                    val array = response.body()?.recipes
                    val adapter = array?.let { RecipeAdapter(this@MainActivity, array) }
                    listView.adapter = adapter

                }
            }

            override fun onFailure(p0: Call<Recipes>, p1: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "There is no food with that name",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }
}

