package com.sercancelik.vize_2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sercancelik.vize_2.databinding.ActivityMainBinding
import com.sercancelik.vize_2.services.Catalog
import com.sercancelik.vize_2.services.XmlService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listCatalog = mutableListOf<Catalog>()
    @SuppressLint("SetTextI18n")
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
        loadAndPrintPlants()

        var tempSearchList: List<Catalog> = emptyList()

        binding.btnSearch.setOnClickListener {
            if (binding.searchEditText.text.isEmpty()) {
                Toast.makeText(this, "Aranacak bir değer giriniz", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            tempSearchList = searchPlants()
            val bulununDetaySayisi = tempSearchList.size.toString()
            binding.findedEditText.text = "Bulunan : "
            binding.countEditText.text = bulununDetaySayisi


        }
        binding.btnDetail.setOnClickListener {
            if (tempSearchList.isEmpty()) {
                Toast.makeText(this, "Öğe bulanamadı!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, Detail::class.java)
            intent.putExtra("plant", tempSearchList[0])
            startActivity(intent)

        }


    }

    fun loadAndPrintPlants() {
        val xmlService = XmlService()
        xmlService.xmlLoad { plants ->
            listCatalog.addAll(plants)

        }
    }

    fun searchPlants(): List<Catalog> {
        val searchText = binding.searchEditText.text.toString()
        return listCatalog.filter {
            it.common.contains(searchText)
        }
    }

}