package com.example.eray_altilar_vize_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eray_altilar_vize_2.databinding.ActivityMainBinding
import com.example.eray_altilar_vize_2.services.PlantCatalogService
import java.util.ArrayList

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

        /// Verilere uygulamanın ilk sayfası yüklendiğinde erişmiş oluyoruz
        val service = PlantCatalogService()
        service.plantCatalogLoad()

        Thread {
            service.plantCatalogLoad()
        }.start()


        binding.btnSearch.setOnClickListener {
            val inputText = binding.inputSearch.text.toString()
            val resultCount = service.searchCounter(inputText)

            /// Arama buttonun bastığımızda kaç tane sonuç aldığımızı ekranımıza yazdırıyoruz
            binding.txtResultCount.text = resultCount.toString()

        }

        binding.btnDetail.setOnClickListener {
            val inputText = binding.inputSearch.text.toString()
            val searchResult = service.searchByInput(inputText)
            val i = Intent(this,DetailActivity::class.java)

            Log.d("result" , searchResult.toString())

            i.putExtra("Result", ArrayList(searchResult))
            startActivity(i)
        }
    }
}