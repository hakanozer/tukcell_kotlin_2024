package com.aliberkaygedikoglu.odev8

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliberkaygedikoglu.odev8.adapter.RecipesAdaptor
import com.aliberkaygedikoglu.odev8.config.ApiClient
import com.aliberkaygedikoglu.odev8.databinding.ActivityMainBinding
import com.aliberkaygedikoglu.odev8.model.Recipe
import com.aliberkaygedikoglu.odev8.model.Recipes
import com.aliberkaygedikoglu.odev8.service.IService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dummyService: IService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dummyService = ApiClient.getClient().create(IService::class.java)
        dummyService.getRecipes().enqueue(object : Callback<Recipes> {
            override fun onResponse(p0: Call<Recipes>, p1: Response<Recipes>) {
                if (p1.isSuccessful) {
                    val arr = p1.body()!!.recipes

                    searchListener(arr)

                    val recipesAdaptor = RecipesAdaptor(this@MainActivity, arr)
                    binding.list.adapter = recipesAdaptor


                    Log.d("datas", arr.toString())


                }
            }

            override fun onFailure(p0: Call<Recipes>, p1: Throwable) {
                Log.e("getProducts", p1.message!!)
            }
        })


    }

    private fun searchListener(arr: List<Recipe>) {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean { // Klavye üzerindeki arama iconu ile çalışır.

                return true
            }

            override fun onQueryTextChange(newText: String): Boolean { // Harf girdikçe veya sildikçe çalışır.

                val filteredList = arr.filter { it.name.lowercase().contains(newText) }
                binding.list.adapter = RecipesAdaptor(this@MainActivity, filteredList)

                return true
            }
        })
    }
}