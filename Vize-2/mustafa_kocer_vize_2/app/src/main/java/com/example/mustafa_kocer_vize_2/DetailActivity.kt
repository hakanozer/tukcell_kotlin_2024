package com.example.mustafa_kocer_vize_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mustafa_kocer_vize_2.databinding.ActivityDetailBinding
import com.example.mustafa_kocer_vize_2.databinding.ActivityMainBinding
import com.example.mustafa_kocer_vize_2.models.PlantCatalog
private lateinit var binding: ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // data binding icin gerekli islemler
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedBundle = intent.extras
        if (receivedBundle != null) {
            val COMMON = receivedBundle.getString("COMMON", "")
            val BOTANICAL = receivedBundle.getString("BOTANICAL", "")
            val ZONE = receivedBundle.getString("ZONE", "")
            val LIGHT = receivedBundle.getString("LIGHT", "")
            val PRICE = receivedBundle.getString("PRICE", "")
            val AVAILABILITY = receivedBundle.getString("AVAILABILITY", "")

            // aldığım bundle'ı görsel arayüze uyguluyorum
            binding.txtCommon.text = "Common : $COMMON"
            binding.txtBotanical.text = "Botanical : $BOTANICAL"
            binding.txtZone.text = "Zone : $ZONE"
            binding.txtLight.text = "Light : $LIGHT"
            binding.txtPrice.text = "Price : $PRICE"
            binding.txtAvailability.text = "Availability : $AVAILABILITY"
        }


        binding.btnBack.setOnClickListener {
            // geriye dönme butonu
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    } // the end of the on create
}