package com.bengisusahin.bengisu_sahin_vize02

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bengisusahin.bengisu_sahin_vize02.databinding.ActivityMainBinding
import com.bengisusahin.bengisu_sahin_vize02.models.Plant
import com.bengisusahin.bengisu_sahin_vize02.services.XmlService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
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

        // Bitki listesini almak için thread'i başlatıyoruz
        Thread {
            val plantList = XmlService().xmlLoad()
            binding.buttonArama.setOnClickListener {
                val searchText = binding.searchView.text.toString()
                // Arama metniyle eşleşen bitkileri filter methodu sayesinde filtreledik
                val filteredPlant = plantList.filter { plant ->
                    plant.COMMON.contains(searchText, ignoreCase = true)
                }
                // count methoduyla aranan bitkiyle eşleşen bitki sayısını döndürdük
                binding.textViewBulunan.text = "Bulunan : " + filteredPlant.count().toString()

                binding.buttonDetay.setOnClickListener {
                    if (filteredPlant.isNotEmpty()) {
                        val intent = Intent(this, DetailActivity::class.java )
                        intent.putExtra("detailCommon", filteredPlant[0].COMMON)
                        intent.putExtra("detailBotanical", filteredPlant[0].BOTANICAL)
                        intent.putExtra("detailZone", filteredPlant[0].ZONE)
                        intent.putExtra("detailLight", filteredPlant[0].LIGHT)
                        intent.putExtra("detailPrice", filteredPlant[0].PRICE)
                        intent.putExtra("detailAvailability", filteredPlant[0].AVAILABILITY)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Bir plant bulunamadı.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }.start()

    }


//    private fun search() {
//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            @SuppressLint("SetTextI18n")
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                query?.let {
//                    Thread {
//
//
//
//                    }.start()
//                }
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                // Kullanıcı metin değişikliği yaptığında arama yapılmasını istemediğim için kullanmadım.
//                return true
//            }
//        })
//    }

}