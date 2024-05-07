package com.beyzaparlak.vize2

import android.content.Intent
import android.os.Bundle
import android.util.Xml
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.beyzaparlak.vize2.databinding.ActivityMainBinding
import com.beyzaparlak.vize2.service.Plant
import com.beyzaparlak.vize2.service.XMLService
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    // --- binding ---
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // --- binding ---
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = mutableListOf<Plant>()
        val xmlService = XMLService()

        thread {
            list = xmlService.xmlLoad()
            // ara butonuna tıklanınca filtreleme ve yazdırma işlemi
            binding.btnSearch.setOnClickListener {

                val searchText = binding.txtSearch.text.toString()

                // aranan değer listede var mı kontrol ediyorum
                val result = list.filter {
                    plant -> plant.COMMON.contains(searchText, ignoreCase = true)
                }

                val stringBuilder = StringBuilder()

                result.forEach { plant ->
                    stringBuilder.append("${plant.COMMON}: ${plant.PRICE}\n")
                }
                binding.txtResult.text = "BULUNAN DEGER : " + result.count().toString()

                // detaylar butonuna basılınca
                binding.btnDetail.setOnClickListener {
                    if (result.isNotEmpty()) {
                        val selectPlant = result.first()
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra("Common", selectPlant.COMMON)
                        intent.putExtra("Availability", selectPlant.AVAILABILITY)
                        intent.putExtra("Price", selectPlant.PRICE)
                        intent.putExtra("Botanical", selectPlant.BOTANICAL)
                        intent.putExtra("Zone", selectPlant.ZONE)
                        intent.putExtra("Light", selectPlant.LIGHT)
                        startActivity(intent)
                        // geri dönünce bitir
                        finish()
                    }
                    // bitki bulunamadı mesajı hata mesajı
                    else {
                        Toast.makeText(this, "Sonuç Bulunamadı.. ", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }.start()
    }
}