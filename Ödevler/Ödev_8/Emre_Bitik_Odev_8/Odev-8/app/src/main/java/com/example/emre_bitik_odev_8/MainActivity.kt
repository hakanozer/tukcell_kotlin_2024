package com.example.emre_bitik_odev_8

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.emre_bitik_odev_8.services.DummyService
import com.example.emre_bitik_odev_8.configs.ApiClient
import com.example.emre_bitik_odev_8.models.Products
import com.example.emre_bitik_odev_8.adaptors.ProductAdaptors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var dummyService : DummyService
    lateinit var listViewProducts: ListView
    lateinit var txtSearch : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listViewProducts = findViewById(R.id.listViewProducts)
        txtSearch = findViewById(R.id.txtSearch)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.getProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if(response.isSuccessful){
                    val arr = response.body()!!.recipes
                    val productAdaptors = ProductAdaptors(this@MainActivity, arr)
                    listViewProducts.adapter = productAdaptors

                    listViewProducts.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                        val selectedProduct = arr[position] // listedeki position konumuna göre elemanları alma
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra("Name", selectedProduct.name) // isim
                        intent.putExtra("Calories", selectedProduct.caloriesPerServing)// kalori
                        var Ingredient = selectedProduct.ingredients.reduce { acc, s -> "$acc,$s" } // List elemanları birleştirme aralarına virgül koyma
                        var Instructions = selectedProduct.instructions.reduce { acc, s -> acc + s }// List elemanları birleştirme
                        intent.putExtra("Ingredients", Ingredient) // içindekiler
                        intent.putExtra("Instructions", Instructions) // talimatlar
                        intent.putExtra("Servings", selectedProduct.servings) // Servis sayısı
                        intent.putExtra("Cuisine", selectedProduct.cuisine) // Ait Oldugu Mutfak
                        intent.putExtra("Image",selectedProduct.image) // yemeğe ait resim

                        startActivity(intent)
                    }

                    txtSearch.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                            val searchText = s.toString().lowercase(Locale.getDefault())
                            val filteredList = arr.filter { it.name.lowercase(Locale.getDefault()).contains(searchText) }
                            val productAdaptors = ProductAdaptors(this@MainActivity, filteredList)
                            listViewProducts.adapter = productAdaptors
                        }

                        override fun afterTextChanged(s: Editable?) {}
                    })
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("GetRecipe", t.message!!)
            }

        })

    }
}
