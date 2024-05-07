package com.example.vize_2.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vize_2.R
import com.example.vize_2.databinding.ActivityMainBinding
import com.example.vize_2.model.PlantCatalog
import com.example.vize_2.service.PlantCatalogService
import com.example.vize_2.service.PlantKatalogServiceImp
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var searchedList: List<PlantCatalog>
    private lateinit var plantList: List<PlantCatalog>




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
        }

        plantList = mutableListOf()
        searchedList = mutableListOf()


        Thread {
            plantList =  PlantKatalogServiceImp().getAllData().toMutableList()
            Log.i("info", plantList.toString())
        }.start()





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.searchBtn.setOnClickListener {
            val searchQuery = binding.searchEditText.text.toString().trim()
            searchedList = if (searchQuery.isBlank()) {
                emptyList()
            } else {
                PlantKatalogServiceImp().searchByCommon(searchQuery, plantList)
            }

            Log.i("searchedList", searchQuery)

            if (searchedList.isEmpty()){
                Snackbar.make(binding.root, "Bitki Bulunamadı", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.root, "${searchedList.size} Bitki Bulundu", Snackbar.LENGTH_SHORT).show()
            }
            binding.foundTextView.text = searchedList.size.toString()
        }


        binding.showDetailBtn.setOnClickListener {
            if(searchedList.isNotEmpty()){
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("plant",searchedList[0])
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Öncelikle Arama Yapmalısınız", Toast.LENGTH_SHORT).show()
            }

        }
    }
}