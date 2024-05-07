package com.example.yunus_emre_ceylan_snav2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yunus_emre_ceylan_snav2.Services.XmlService
import com.example.yunus_emre_ceylan_snav2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var btnSearch: Button
    lateinit var btnDetail: Button
    lateinit var text: TextView
    lateinit var count: TextView
    lateinit var search: EditText
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnSearch = binding.searchBtn
        btnDetail = binding.detail
        search = binding.search
        text = binding.textView
        count = binding.count

        val xmlService = XmlService()
        var list = mutableListOf<Plant>()
        Thread {
            list = xmlService.xmlLoad()
            btnSearch.setOnClickListener {
                val searchText = search.text.toString()
                val filteredList = list.filter { plant -> plant.Common.contains(searchText, ignoreCase = true) }

                val stringBuilder = StringBuilder()
                filteredList.forEach { plant ->
                    stringBuilder.append("${plant.Common}: ${plant.Price}\n")
                }
                text.text = if (stringBuilder.isNotEmpty()) stringBuilder.toString() else "No matching plants found."
                count.text = "Bulunan Sayısı: " + filteredList.count().toString()

                btnDetail.setOnClickListener {
                    if (filteredList.isNotEmpty()) {
                        val selectedPlant = filteredList.first()
                        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                        intent.putExtra("Common", selectedPlant.Common)
                        intent.putExtra("Availability", selectedPlant.Availabilty)
                        intent.putExtra("Price",selectedPlant.Price)
                        intent.putExtra("Botanical",selectedPlant.Botanical)
                        intent.putExtra("Zone",selectedPlant.Zone)
                        intent.putExtra("Light",selectedPlant.Light)
                        startActivity(intent)
                        finish()
                    } else {
                        // Listede bitki yoksa bir hata mesajı gösterebilirsiniz.
                        Toast.makeText(this@MainActivity, "No plants found.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }.start()

    }


}