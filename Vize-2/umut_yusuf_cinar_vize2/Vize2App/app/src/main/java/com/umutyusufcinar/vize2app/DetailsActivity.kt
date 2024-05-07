package com.umutyusufcinar.vize2app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.umutyusufcinar.vize2app.service.Common

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedBundle: Bundle?) {
        super.onCreate(savedBundle)
        setContentView(R.layout.activity_details)

        val commonName = findViewById<TextView>(R.id.common_name)
        val botanical = findViewById<TextView>(R.id.botanical)
        val zone = findViewById<TextView>(R.id.zone)
        val light = findViewById<TextView>(R.id.light)
        val price = findViewById<TextView>(R.id.price)

        //Deprecated olsa bile derste bunu gördüğümüzü anımsadığım için bu şekilde çözeceğim
        val common = intent.getSerializableExtra("PLANT_DETAILS") as? Common

        if (common != null) {
            commonName.text = "Common: ${common.commonName}"
            botanical.text = "Botanical: ${common.botanical}"
            zone.text = "Zone: ${common.zone}"
            light.text = "Light: ${common.light}"
            price.text = "Price: ${common.price}"
        } else {
            commonName.text = "erorr"
        }

        // Buton için onClickListener ekleyin
        val backButton = findViewById<Button>(R.id.back_to_main)
        backButton.setOnClickListener {
            // MainActivity'ye geri dönmek için Intent
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)  // Aktivite değiştir
        }
    }
}


