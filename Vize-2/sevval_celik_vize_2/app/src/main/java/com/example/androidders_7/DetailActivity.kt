package com.example.androidders_7

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidders_7.databinding.ActivityDetailBinding
import com.example.androidders_7.services.XmlService

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val common = intent.getStringExtra("Common") ?: ""
        val botanical = intent.getStringExtra("Botanical") ?: ""
        val zone = intent.getStringExtra("Zone") ?: ""
        val light = intent.getStringExtra("Light") ?: ""
        val price = intent.getStringExtra("Price") ?: ""
        val availability = intent.getStringExtra("Availability") ?: ""

        binding.textCommon.text = "Common: $common"
        binding.textBotanical.text = "Botanical: $botanical"
        binding.textZone.text = "Zone: $zone"
        binding.textLight.text = "Light: $light"
        binding.textPrice.text = "Price: $price"
        binding.textAvailability.text = "Availability: $availability"
    }
}

