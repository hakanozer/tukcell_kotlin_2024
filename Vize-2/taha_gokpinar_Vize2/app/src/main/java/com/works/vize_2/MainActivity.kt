package com.works.vize_2

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.vize_2.Models.Catalog
import com.works.vize_2.Services.XmlService
import com.works.vize_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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


        binding.searchBtn.setOnClickListener(){

            val datas = mutableListOf<Catalog>()
            val aramaMetni = binding.editTextSearch.text.toString().lowercase()
            var toplam = 0

            val xmlService = XmlService()
            Thread{
                for (it in xmlService.xmlLoad()){
                    if(it.common.lowercase().contains(aramaMetni)){
                        toplam += 1
                        datas.add(it)
                    }
                }

                if (toplam > 0){
                    binding.textViewToplam.text = "Bulunan toplam bitki sayısı: $toplam"
                }
                else{
                    binding.textViewToplam.text = "Aramanızla eşleşen bitki bulunamadı."
                }

            }.start()

            binding.detailBtn.setOnClickListener(){
                if (datas.isNotEmpty()){
                    val intent = Intent(this, DetailActivity::class.java)
                    val data = datas[0]
                    intent.putExtra("data", data)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Veri bulunamadı!", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}