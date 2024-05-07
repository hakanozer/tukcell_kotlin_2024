package com.tlh.vize2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button

import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {

    private lateinit var usertCommonTxt: TextView
    private lateinit var userBotanicalTxt: TextView
    private lateinit var usertxtZone: TextView
    private lateinit var userLightTxt: TextView
    private lateinit var userPriceTxt: TextView
    private lateinit var txtAvailability: TextView
    private lateinit var userBackButton: Button

    companion object {
        var compPlant: Plant? = null
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        usertCommonTxt = findViewById(R.id.textCommon)
        userBotanicalTxt = findViewById(R.id.textBotanical)
        usertxtZone = findViewById(R.id.textZone)
        userLightTxt = findViewById(R.id.textLight)
        userPriceTxt = findViewById(R.id.textPrice)
        txtAvailability = findViewById(R.id.textAvailability)
        userBackButton = findViewById(R.id.backButton)


        if (compPlant != null) {
            usertCommonTxt.text = "COMMON:" + compPlant!!.common
            userBotanicalTxt.text = "BOTANICAL:" + compPlant!!.botanical
            usertxtZone.text = "ZONE:" + compPlant!!.zone.toString()
            userLightTxt.text = "LIGHT:" + compPlant!!.light
            userPriceTxt.text = "PRICE:" + compPlant!!.price
            txtAvailability.text = "AVAILABILITY:" + compPlant!!.availability
        }
        userBackButton.setOnClickListener {
            onBackPressed()
        }

    }
}