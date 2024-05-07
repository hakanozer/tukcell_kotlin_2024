package com.ns.enesarisoy_vize2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ns.enesarisoy_vize2.databinding.ActivityMainBinding
import com.ns.enesarisoy_vize2.model.Plant
import com.ns.enesarisoy_vize2.util.showToast
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val plants = mutableListOf<Plant>()
    private var searchResult: List<Plant> = listOf()

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


        Thread {
            getPlants()
        }.start()


        with(binding) {
            btnDetail.isEnabled = false

            btnSearch.setOnClickListener {
                val searchPlant = etSearch.text.trim().toString()

                if (searchPlant.isEmpty()) {
                    showToast("Arama yapmak için bir kelime giriniz")
                    return@setOnClickListener
                }

                searchResult = searchPlantsByKeyword(plants, searchPlant)
                tvResult.text = searchResult.size.toString()

                val message = if (searchResult.isNotEmpty()) {
                    "${searchResult.size} tane bitki bulundu"
                } else {
                    "Arama sonucuna göre bitki bulunamadı"
                }
                showToast(message)

                btnDetail.isEnabled = searchResult.isNotEmpty()
            }

            btnDetail.setOnClickListener {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("plant", searchResult.first())
                startActivity(intent)
            }
        }

    }


    private fun getPlants() {
        val url = "https://www.w3schools.com/xml/plant_catalog.xml"

        try {
            val doc: Document = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()
            val plantElements = doc.select("PLANT")

            for (plantElement in plantElements) {
                val commonName = plantElement.getElementsByTag("COMMON").text() ?: ""
                val botanicalName = plantElement.getElementsByTag("BOTANICAL").text() ?: ""
                val zone = plantElement.getElementsByTag("ZONE").text() ?: ""
                val light = plantElement.getElementsByTag("LIGHT").text() ?: ""
                val price = plantElement.getElementsByTag("PRICE").text() ?: ""
                val availability = plantElement.getElementsByTag("AVAILABILITY").text() ?: ""

                val plant = Plant(commonName, botanicalName, zone, light, price, availability)
                plants.add(plant)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun searchPlantsByKeyword(plants: List<Plant>, keyword: String): List<Plant> {
        return plants.filter { it.commonName.contains(keyword, ignoreCase = true) }
    }

}