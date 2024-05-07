package com.toren.vize2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.toren.vize2.R
import com.toren.vize2.databinding.ActivityMainBinding
import com.toren.vize2.model.Plant
import com.toren.vize2.service.XmlService

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private val data = mutableListOf<Plant>()
    private var filteredData = listOf<Plant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service = XmlService()

        Thread {
            data.addAll( service.plantLoad() )
            runOnUiThread {
                updateData()
            }
        }.start()

        binding.apply {

            detailBtn.setOnClickListener {
                if(filteredData.isNotEmpty()) {
                val i = Intent(this@MainActivity, DetailActivity::class.java)
                i.putExtra("data", filteredData[0])
                startActivity(i)
            } else {
                Toast.makeText(this@MainActivity, "Önce arama yapmanız gerekiyor!", Toast.LENGTH_SHORT).show()
            }
        }
            searchBtn.setOnClickListener {
                if (data.isNotEmpty()) {
                    val search = searchEditTxt.text.toString().lowercase()
                    filteredData = data.filter { it.common.lowercase().contains(search) }
                    val size = filteredData.size.toString()
                    foundItemTw.text = "Bulanan sonuç: $size"
                }
            }
        }

    }

    private fun updateData() {
        binding.foundItemTw.text = "Veriler yüklendi."
    }

}