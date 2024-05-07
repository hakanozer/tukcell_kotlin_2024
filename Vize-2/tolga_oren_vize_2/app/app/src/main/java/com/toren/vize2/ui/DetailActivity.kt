package com.toren.vize2.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.toren.vize2.R
import com.toren.vize2.databinding.ActivityDetailBinding
import com.toren.vize2.model.Plant

class DetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

        val data = intent.getSerializableExtra("data") as Plant

        data?.let {
            binding.apply {
                commonTw.text = data.common
                botanicalTw.text = data.botanical
                zoneTw.text = data.zone
                lightTw.text = data.light
                priceTw.text = data.price
                availabilityTw.text = data.availability.toString()
            }
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}