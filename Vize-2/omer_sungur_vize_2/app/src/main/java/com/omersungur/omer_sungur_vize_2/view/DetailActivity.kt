package com.omersungur.omer_sungur_vize_2.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.omersungur.omer_sungur_vize_2.R
import com.omersungur.omer_sungur_vize_2.common.Constants.PLANT_KEY
import com.omersungur.omer_sungur_vize_2.databinding.ActivityDetailBinding
import com.omersungur.omer_sungur_vize_2.model.Plant

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var data: Plant? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        getDataFromMainActivity()
        setTextViewForPlant()

        binding.ivBack.setOnClickListener {
            showAlertDialog(it)
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun getDataFromMainActivity() {
        data = intent.getSerializableExtra(PLANT_KEY, Plant::class.java)
    }

    @SuppressLint("SetTextI18n")
    private fun setTextViewForPlant() {
        val commonText = getString(R.string.common_text, data?.common)
        val botanicalText = getString(R.string.botanical_text, data?.botanical)
        val zoneText = getString(R.string.zone_text, data?.zone)
        val lightText = getString(R.string.light_text, data?.light)
        val priceText = getString(R.string.price_text, data?.price)
        val availabilityText = getString(R.string.availability_text, data?.availability)

        binding.apply {
            tvCommon.text = commonText
            tvBotanical.text = botanicalText
            tvZone.text = zoneText
            tvLight.text = lightText
            tvPrice.text = priceText
            tvAvailability.text = availabilityText
        }
    }

    private fun intentFromDetailActivityToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showAlertDialog(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Navigate to Main Page")
        builder.setMessage("Are you sure!")

        builder.setPositiveButton("Yes") { _, _ ->
            intentFromDetailActivityToMainActivity()
        }

        builder.setNegativeButton("No") { _, _ ->
            Snackbar.make(this, view, "Fail!", Snackbar.LENGTH_LONG).show()
        }

        val alert = builder.create()
        alert.show()
    }
}