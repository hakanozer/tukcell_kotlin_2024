package com.example.androidders_7

import android.content.Intent
import android.os.Bundle

import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.androidders_7.databinding.ActivityMainBinding
import com.example.androidders_7.services.XmlService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
     var cdList= mutableListOf<cdData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val xmlService = XmlService()

        Thread {
            cdList = xmlService.cdLoad()
            cdList.forEach { item ->
                Log.d("cdData", "Common: ${item.common}")
            }
            binding.btnAra.setOnClickListener {
                val searchText = binding.searchEditText.text.toString()
                val listSonuc=cdList.filter{  cdVeri -> cdVeri.common.contains(searchText, ignoreCase = true)}

                val countText = "${listSonuc.count()}"
                binding.txtSonuc.setText(countText)

                binding.btnDetay.setOnClickListener {
                    if (listSonuc.isNotEmpty()) {
                        val selectedPlant = listSonuc.first()
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra("Common", selectedPlant.common)
                        intent.putExtra("Botanical",selectedPlant.botanical)
                        intent.putExtra("Zone",selectedPlant.zone)
                        intent.putExtra("Light",selectedPlant.light)
                        intent.putExtra("Price",selectedPlant.price)
                        intent.putExtra("Availability", selectedPlant.availability)
                        startActivity(intent)
                    } else {
                        Log.d("MainActivity", "veri yüklenemedi")

                    }
                }


            }

        }.start()







        }



    }

