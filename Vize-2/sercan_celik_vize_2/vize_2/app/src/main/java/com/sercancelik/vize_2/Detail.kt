package com.sercancelik.vize_2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sercancelik.vize_2.databinding.ActivityDetailBinding
import com.sercancelik.vize_2.databinding.ActivityMainBinding
import com.sercancelik.vize_2.services.Catalog

class Detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        val plant = intent.getSerializableExtra("plant") as Catalog
        binding.textCommon.text = "Common: ${plant.common}"
        binding.textBotanical.text = "Botanical: ${plant.botanical}"
        binding.textZone.text = "Zone: ${plant.zone}"
        binding.textLight.text = "Light: ${plant.light}"
        binding.textPrice.text = "Price: ${plant.price}"
        binding.textAvailability.text = "Availability: ${plant.availability}"


    }

}