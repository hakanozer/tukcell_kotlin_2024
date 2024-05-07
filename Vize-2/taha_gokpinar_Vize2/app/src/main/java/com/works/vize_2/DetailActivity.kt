package com.works.vize_2

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.vize_2.Models.Catalog
import com.works.vize_2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
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

        val data = intent.getSerializableExtra("data", Catalog::class.java )

        binding.textViewCommon.text = "Common: ${data!!.common}"
        binding.textViewBotanical.text = "Botanical: ${data.botanical}"
        binding.textViewZone.text = "Zone: ${data.zone}"
        binding.textViewLight.text = "Light: ${data.light}"
        binding.textViewPrice.text = "Price: ${data.price}"
        binding.textViewAvailability.text = "Availability: ${data.availability}"
    }
}