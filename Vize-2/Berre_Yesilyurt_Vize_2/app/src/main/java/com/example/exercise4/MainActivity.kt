package com.example.exercise4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exercise4.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name="Berre"
        val password="123"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val a=Data()

        Thread{
            val plantList=a.load() // Veriyi xml ile çektik ve bir liste döndü
            Log.d("plantList",plantList.toString())

                runOnUiThread { // UI işlemleri
                    var firstElemanOnPlantList: Plant? = null // Dönen ve filtrelenen listenin ilk elemanını alabilmek için globalde bir değişken tanımlandı

                    binding.search.setOnClickListener { // Ara tuşuna basıldığında liste içinde uyan kriterler aranıyor
                        var text=binding.textSeacrh.text.toString()
                        var filteredPlantList=plantList?.filter {
                            it.common==text
                        }

                        Log.d("filter",filteredPlantList.toString())

                        firstElemanOnPlantList=filteredPlantList?.find {// Uyan ilk eleman alınıyor
                            it.common==text
                        }
                        Log.d("first",firstElemanOnPlantList.toString())

                        binding.textFounded.text="Bulunan : "+filteredPlantList?.size.toString() // Uyan eleman sayısı

                    }

                    binding.goToDetail.setOnClickListener {// Detay sayfasına gidildiğinde ise Serializable nesnesi gönderiliyor
                        val  intent=Intent(this,Other::class.java)
                        intent.putExtra("serializable",firstElemanOnPlantList)
                        startActivity(intent)


                    }

                }
        }.start()





    }
}