package com.emrecura.vize_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.emrecura.vize_2.databinding.ActivityMainBinding
import com.emrecura.vize_2.models.Plant
import com.emrecura.vize_2.services.XMLService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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


        val searchPlantList = mutableListOf<Plant>()
        Thread {
            val plantList = XMLService().xmlLoad()
            runOnUiThread {
                binding.btnAra.setOnClickListener {
                    searchPlantList.clear()
                    getPlants(plantList,searchPlantList)
                }

                binding.btnDetail.setOnClickListener {
                    val plant = searchPlantList.get(0)
                    val intent = Intent(this,DetailsActivity::class.java)
                    intent.putExtra("plant", plant)
                    startActivity(intent)
                }

            }

        }.start()

    }
    fun getPlants(plantList: List<Plant>, list: MutableList<Plant>){
        val searchTerm = binding.searchEditText.text.toString().lowercase()
        for (item in plantList){
            if (item.common.lowercase().contains(searchTerm)){
                list.add(item)
            }
        }
        binding.bulunanText.text = "Bulunan : ${list.size}"
    }

}