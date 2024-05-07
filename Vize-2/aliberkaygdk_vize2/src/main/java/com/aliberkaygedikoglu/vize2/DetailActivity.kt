package com.aliberkaygedikoglu.vize2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliberkaygedikoglu.vize2.databinding.ActivityDetailBinding
import com.aliberkaygedikoglu.vize2.models.Plant

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data = intent.extras?.getSerializable("common") as? Plant

        if (data != null) {

            binding.textViewCommon.setText("Common: ${data.common}")
            binding.textViewBotanical.setText("Botanical: ${data.botanical}")
            binding.textViewZone.setText("Zone: ${data.zone}")
            binding.textViewLight.setText("Light: ${data.light}")
            binding.textViewPrice.setText("Price: ${data.price}")
            binding.textViewAvailability.setText("Availability: ${data.availability}")


        }

    }
}