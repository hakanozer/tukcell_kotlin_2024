package com.muratdayan.odev8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muratdayan.odev8.adapters.RecipeAdapter
import com.muratdayan.odev8.configs.ApiClient
import com.muratdayan.odev8.databinding.ActivityMainBinding
import com.muratdayan.odev8.models.Recipe
import com.muratdayan.odev8.models.Recipes
import com.muratdayan.odev8.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable
import java.util.concurrent.CompletableFuture

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var iDummyService: IDummyService
    private lateinit var recipeAdapter: RecipeAdapter
    lateinit var recipeList: List<Recipe>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.progBar.visibility = View.VISIBLE


        // interface'i sınıfa çevirerek nesnesini oluşturduk
        iDummyService = ApiClient.getClient().create(IDummyService::class.java)

        iDummyService.getAllRecipes().enqueue(object : Callback<Recipes>{
            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {

                binding.progBar.visibility = View.GONE
                if (response.isSuccessful){
                    // response nesnesinin boş olmadıgını kontrol ettik
                    recipeList = response.body()!!.recipes
                    //Log.d("responsedata", recipeList[0].name)
                    recipeAdapter =RecipeAdapter(this@MainActivity,recipeList)
                    binding.listViewRecipes.adapter = recipeAdapter

                    binding.btnSearch.setOnClickListener {
                        val searchText = binding.editTxtSearchRecipe.text.toString().trim()
                        // asağıdaki yorum satırları kapsamında,  gelen veriyi filtreleme işlemi yaptık
                        /*if (searchText.isNotEmpty()){
                            val filteredRecipeList = recipeList.filter {
                                it.name.contains(searchText,ignoreCase = true)
                            }
                            recipeAdapter =RecipeAdapter(this@MainActivity,filteredRecipeList)
                            binding.listViewRecipes.adapter = recipeAdapter
                        }else{
                            recipeAdapter =RecipeAdapter(this@MainActivity,recipeList)
                            binding.listViewRecipes.adapter = recipeAdapter
                        }*/

                        // api servisindeki search methodunu kullanarak veriyi filtreleme işlemi yaptık
                        iDummyService.searchRecipes(searchText).enqueue(object : Callback<Recipes>{
                            override fun onResponse(p0: Call<Recipes>, res: Response<Recipes>) {
                                if (res.isSuccessful) {
                                    val responseList = res.body()!!.recipes
                                    recipeAdapter =RecipeAdapter(this@MainActivity,responseList)
                                    binding.listViewRecipes.adapter = recipeAdapter
                                }
                            }

                            override fun onFailure(p0: Call<Recipes>, err: Throwable) {
                                Log.e("onfailuresearch",err.message.toString())
                            }

                        })
                    }
                }
            }

            override fun onFailure(call: Call<Recipes>, error: Throwable) {
                binding.progBar.visibility = View.GONE
                Log.e("failuregetallrecipes", "onFailure: ${error.message}", )
            }
        })


        binding.listViewRecipes.setOnItemClickListener { parent, view, position, id ->

            if (recipeList.isNotEmpty()){
                val recipe = recipeList[position]
                // DetailActivity'e geçiş yap
                val intent = Intent(this, DetailActivity::class.java)
                // Seçilen öğenin ID'sini intent ile gönder
                intent.putExtra("recipe", recipe)
                // Activity'yi başlat
                startActivity(intent)
            }
        }
    }


}