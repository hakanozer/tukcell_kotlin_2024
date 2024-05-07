package com.ns.enesarisoy_vize2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ns.enesarisoy_vize2.databinding.ActivityDetailBinding
import com.ns.enesarisoy_vize2.model.Plant

class DetailActivity : AppCompatActivity() {

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

        val plant = intent.getSerializableExtra("plant") as Plant
        with(binding) {
            tvCommon.text = "Common: ${plant.commonName}"
            tvBotanical.text = "Botanical: ${plant.botanicalName}"
            tvZone.text = "Zone: ${plant.zone}"
            tvLight.text = "Light: ${plant.light}"
            tvPrice.text = "Price: ${plant.price}"
            tvAvailability.text = "Availability: ${plant.availability}"

            ivBack.setOnClickListener {
                finish()
            }
        }
    }
}