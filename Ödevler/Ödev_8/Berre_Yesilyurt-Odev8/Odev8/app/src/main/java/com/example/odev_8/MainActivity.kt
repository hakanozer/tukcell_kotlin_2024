package com.example.odev_8

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
import com.example.odev_8.Models.Recipe
import com.example.odev_8.Models.Recipes
import com.example.odev_8.adaptors.RecipeAdaptors
import com.example.odev_8.configs.ApiClient
import com.example.odev_8.services.IDummyService
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

        listView=findViewById(R.id.listView)
        searchButton=findViewById(R.id.btnSearch)
        searchText=findViewById(R.id.search)

        dummyService=ApiClient.getClient().create(IDummyService::class.java)
        dummyService.getRecipes().enqueue(object : Callback<Recipes>{
            override fun onResponse(p0: Call<Recipes>, p1: Response<Recipes>) {
                if(p1.isSuccessful){
                    arr=p1.body()!!.recipes
                    Log.d("data",arr.toString())
                    recipeAdaptor=RecipeAdaptors(this@MainActivity,arr)
                    listView.adapter=recipeAdaptor
                }
            }

            override fun onFailure(p0: Call<Recipes>, p1: Throwable) {
                Log.e("getRecipes", p1.message!! )
            }

        })

//        listView.setOnItemClickListener { adapterView, view, i, l ->
//            val selectedRecipe=arr[i] // Tıklanan öğenin bilgilerini alabilmek için pozisyonunu verdik
//            val i=Intent(this,Details::class.java)
//            i.putExtra("recipe",selectedRecipe)
//            startActivity(i)
//        }



        searchButton.setOnClickListener {
            val text=searchText.text.toString()
            filteredRecipe(text)
            //val intent = Intent(this@MainActivity, MainActivity::class.java)
            //startActivity(intent)
            //finish() // Eğer mevcut aktivitenin önceki durumunu temizlemek istiyorsanız
        }


    }
    fun filteredRecipe(text:String){
        val filteredList = arr.filter { it.name.contains(text) }
        //recipeAdaptor = RecipeAdaptors(this@MainActivity, filteredList)
        listView.adapter = RecipeAdaptors(this@MainActivity, filteredList)
        //recipeAdaptor.updateData(filteredList)
        //listView.adapter = recipeAdaptor

    }

    override fun onResume() {
        super.onResume()
        listView.setOnItemClickListener { adapterView, view, i, l ->
            val selectedRecipe = (listView.adapter as RecipeAdaptors).getItem(i)
            val intent = Intent(this, Details::class.java)
            intent.putExtra("recipe", selectedRecipe)
            startActivity(intent)
        }
    }
}
