package com.selincengiz.selin_cengiz_vize_2.presentation

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.selincengiz.selin_cengiz_vize_2.R
import com.selincengiz.selin_cengiz_vize_2.data.entities.PlantResponse
import com.selincengiz.selin_cengiz_vize_2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.detailFunctions = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val plant = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("plant", PlantResponse::class.java)
        } else {
            intent.getParcelableExtra("plant")
        }

        with(binding) {
            tvCommon.text = plant?.common
            tvAvailability.text = plant?.availability
            tvBotanical.text = plant?.botanical
            tvLight.text = plant?.light
            tvPrice.text = plant?.price
            tvZone.text = plant?.zone
        }
    }

    fun backClicked() {
        onBackPressed()
    }
}