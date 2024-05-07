package com.example.omerfaruk_arslan_vize_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.omerfaruk_arslan_vize_2.model.Plant

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedBundle: Bundle?) {
        super.onCreate(savedBundle)
        setContentView(R.layout.activity_details)

        val commonName = findViewById<TextView>(R.id.txtCommon)
        val botanical = findViewById<TextView>(R.id.txtbotanical)
        val zone = findViewById<TextView>(R.id.txtZone)
        val light = findViewById<TextView>(R.id.txtLight)
        val price = findViewById<TextView>(R.id.txtPrice)

        val plant = intent.getSerializableExtra("PLANT_DETAILS") as? Plant

        if (plant != null) {
            commonName.text = "Common: ${plant.Common}"
            botanical.text = "Botanical: ${plant.Botanical}"
            zone.text = "Zone: ${plant.Zone}"
            light.text = "Light: ${plant.Light}"
            price.text = "Price: ${plant.Price}"
        } else {
            commonName.text = "ERROR: Plant details not found."
            botanical.text = ""
            zone.text = ""
            light.text = ""
            price.text = ""
        }

        val backButton = findViewById<Button>(R.id.btnBack)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
