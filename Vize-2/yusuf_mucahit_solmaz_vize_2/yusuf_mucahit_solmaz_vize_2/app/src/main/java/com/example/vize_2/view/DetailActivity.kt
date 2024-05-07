package com.example.vize_2.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vize_2.R
import com.example.vize_2.databinding.ActivityDetailBinding
import com.example.vize_2.model.PlantCatalog

class DetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val plant = intent.getSerializableExtra("plant") as PlantCatalog

        Log.i("ReceivedPlant", plant.toString())

        insertData(plant)


    }

    fun insertData(plant: PlantCatalog){
        binding.availabilityTextView.text = plant.availability
        binding.botanicalTextView.text = plant.botanical
        binding.commonTextView.text = plant.common
        binding.lightTextView.text = plant.common
        binding.priceTextView.text = plant.price
        binding.zoneTextView.text = plant.zone
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_button -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}