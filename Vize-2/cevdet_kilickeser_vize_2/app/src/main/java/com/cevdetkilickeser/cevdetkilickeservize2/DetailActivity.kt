package com.cevdetkilickeser.cevdetkilickeservize2

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.cevdetkilickeser.cevdetkilickeservize2.databinding.ActivityDetailBinding
import com.cevdetkilickeser.cevdetkilickeservize2.models.Plant

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val plant = intent.getSerializableExtra("plant") as? Plant

        plant?.let {
            binding.txtCommon.text = plant.common
            binding.txtBotanical.text = plant.botanical
            binding.txtZone.text = plant.zone
            binding.txtLight.text = plant.light
            binding.txtPrice.text = plant.price
            binding.txtAvailability.text = plant.availability
        }
    }
}