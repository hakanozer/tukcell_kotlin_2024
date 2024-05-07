package com.cevdetkilickeser.cevdetkilickeservize2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cevdetkilickeser.cevdetkilickeservize2.databinding.ActivityMainBinding
import com.cevdetkilickeser.cevdetkilickeservize2.models.Plant
import com.cevdetkilickeser.cevdetkilickeservize2.services.XmlService
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var plantList = mutableListOf<Plant>()
    private var searchedPlantList = mutableListOf<Plant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread{
            val list = XmlService().plantLoad().toMutableList()
            plantList.addAll(list)
            Log.e("şş",plantList.size.toString())


        }.start()

        binding.btnAra.setOnClickListener {
            searchedPlantList.clear()
            val searchingWord = binding.txtAra.text.toString()

            if (searchingWord.isNotBlank()){

                for (plant in plantList){
                    if (plant.common.lowercase().contains(searchingWord.lowercase())){
                        searchedPlantList.add(plant)
                    }
                }

                binding.txtMiktar.text = searchedPlantList.size.toString()

            } else{
                Snackbar.make(it,"Lütfen geçerli bir kelime girin",Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnDetay.setOnClickListener {
            if (searchedPlantList.isEmpty()){
                Snackbar.make(it,"Aradığınız bitki bulunamadı",Snackbar.LENGTH_SHORT).show()
            }else{
                val plant = searchedPlantList[0]
                val intent = Intent(this,DetailActivity::class.java)
                intent.putExtra("plant",plant)
                startActivity(intent)
            }

        }

    }
}