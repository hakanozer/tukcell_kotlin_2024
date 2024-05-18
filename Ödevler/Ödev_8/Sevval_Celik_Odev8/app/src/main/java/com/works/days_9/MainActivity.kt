package com.works.days_9

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.works.days_9.adaptors.RecipeAdaptors
import com.works.days_9.configs.ApiClient
import com.works.days_9.models.Recipe
import com.works.days_9.models.Recipes
import com.works.days_9.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var dummyService: DummyService
    lateinit var listViewProducts: ListView
    lateinit var btn_ara: ImageView
    lateinit var txt_arama: EditText

    private lateinit var recipeAdapters: RecipeAdaptors
    private var orjinalTarifList: List<Recipe> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        listViewProducts = findViewById(R.id.listViewProducts)
        btn_ara = findViewById(R.id.btn_ara)
        txt_arama = findViewById(R.id.txt_arama)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        btn_ara.setOnClickListener {
            val tarifArama = txt_arama.text.toString()
            filterRecipes(tarifArama)
        }

        getRecipes()
        listViewProducts.setOnItemClickListener { _, _, position, _ ->
            val clickedRecipe = orjinalTarifList[position]
            val intent = Intent(this@MainActivity, DetayActivity::class.java).apply {
                putExtra("recipe", clickedRecipe)
            }
            startActivity(intent)
        }


    }


    private fun getRecipes() {
        dummyService.getProducts().enqueue(object : Callback<Recipes> {
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                if (response.isSuccessful) {
                    val recipes = response.body()
                    orjinalTarifList = recipes?.recipes ?: emptyList()
                    displayRecipes(orjinalTarifList)
                } else {
                    Log.d("MainActivity", "tarifler gelmedi.")
                }
            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                Log.d("MainActivity", "error")
            }


        })
    }

    private fun displayRecipes(recipeList: List<Recipe>) {
        recipeAdapters = RecipeAdaptors(this@MainActivity, recipeList)
        listViewProducts.adapter = recipeAdapters
    }

    private fun filterRecipes(query: String) {
        val filtreliTarifList = orjinalTarifList.filter { recipe ->
            recipe.name.contains(query, ignoreCase = true)
        }
        recipeAdapters = RecipeAdaptors(this@MainActivity, filtreliTarifList)
        listViewProducts.adapter = recipeAdapters
    }


}
