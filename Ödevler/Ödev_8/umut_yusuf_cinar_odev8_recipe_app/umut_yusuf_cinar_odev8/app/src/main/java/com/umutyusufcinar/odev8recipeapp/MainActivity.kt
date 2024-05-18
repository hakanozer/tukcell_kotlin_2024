package com.umutyusufcinar.odev8recipeapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.umutyusufcinar.odev8recipeapp.models.Recipe
import com.umutyusufcinar.odev8recipeapp.models.Recipes
import com.umutyusufcinar.odev8recipeapp.adaptors.RecipeAdaptors
import com.umutyusufcinar.odev8recipeapp.configs.ApiClient
import com.umutyusufcinar.odev8recipeapp.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var dummyService:IDummyService
    lateinit var listView: ListView
    lateinit var searchButton:Button
    lateinit var searchText:EditText
    lateinit var recipeAdaptor: RecipeAdaptors
    lateinit var arr:List<Recipe>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContentView(R.layout.activity_main)
        //xml üzerindeki elementler ile id kullanarak eşleştiriyorum
        listView=findViewById(R.id.listView)
        searchButton=findViewById(R.id.btnSearch)
        searchText=findViewById(R.id.search)
        //servisi kullanmak için nesnesini oluşturuyorum
        dummyService=ApiClient.getClient().create(IDummyService::class.java)
        dummyService.getRecipes().enqueue(object : Callback<Recipes> {
            override fun onResponse(p0: Call<Recipes>, p1: Response<Recipes>) {
                if (p1.isSuccessful) {
                    p1.body()?.let {
                        arr = it.recipes
                        Log.d("data", arr.toString())
                        recipeAdaptor = RecipeAdaptors(this@MainActivity, arr)
                        listView.adapter = recipeAdaptor
                    } ?: run {
                        Log.e("getRecipes", "Response body is null")
                    }
                }
            }
            override fun onFailure(p0: Call<Recipes>, p1: Throwable) {
                Log.e("getRecipes", p1.message ?: "Unknown error")
            }
        })


        //arama barına yazılan şeyleri loglaması için bir listener oluşturuyorum
        searchButton.setOnClickListener {
            val text=searchText.text.toString() //yazılan kısımdan metni alıp tutuyorum
            filteredRecipeFunctionForSearch(text) //aramaya göre filtreleme yapan fonksiyon, aşağıda oluşturdum
        }


    }
    //aramaya göre filtreleme yapan fonksiyonu yazacağım
    fun filteredRecipeFunctionForSearch(text:String){
        val filteredList = arr.filter { it.name.contains(text) } //filtrelenmiş öğeleri tutması için bir liste oluşturuyorum
        listView.adapter = RecipeAdaptors(this@MainActivity, filteredList) //adaptor a listeyi veriyorum
    }

    //detaylar sayfasına geçiş yapmak için bir fonskiyon yazacağım bunun için inheritence da kullanıyorum
    override fun onResume() {
        super.onResume()
        //filtrelenmiş öğelerden seçim yapılıp tıklandığında detaylar sayfasına geçeeceğim
        listView.setOnItemClickListener { adapterView, view, i, l ->
            //getITem metodu ile alınan seçilmiş öğeyi bir değişkende tutacağım
            val selectedRecipe = (listView.adapter as RecipeAdaptors).getItem(i)
            val intentvar = Intent(this, DetailsActivity::class.java)
            intent.putExtra("recipe", selectedRecipe)
            startActivity(intentvar)
        }
    }
}

