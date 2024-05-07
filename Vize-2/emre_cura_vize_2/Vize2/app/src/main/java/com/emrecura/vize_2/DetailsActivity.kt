package com.emrecura.vize_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.emrecura.vize_2.databinding.ActivityDetailsBinding
import com.emrecura.vize_2.databinding.ActivityMainBinding
import com.emrecura.vize_2.models.Plant

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backImage.setOnClickListener {
            finish()
        }
        getInfo()
    }

    fun getInfo(){
        val intentPlant = intent.getSerializableExtra("plant") as Plant?
        binding.commonText.text = "Common: ${intentPlant?.common}"
        binding.botanicalText.text = "Botanical: ${intentPlant?.botanical}"
        binding.zoneText.text = "Zone: ${intentPlant?.zone}"
        binding.lightText.text = "Light: ${intentPlant?.light}"
        binding.priceText.text = "Price: ${intentPlant?.price}"
        binding.availabilityText.text = "Availability: ${intentPlant?.availability}"

    }

}