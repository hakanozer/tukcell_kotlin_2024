package com.example.yunus_emre_ceylan_snav2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yunus_emre_ceylan_snav2.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    lateinit var text1: TextView
    lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        text1 = binding.txtDetail
        btnBack = binding.back

        btnBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val Common = intent.getStringExtra("Common")
        val Botanical = intent.getStringExtra("Botanical")
        val Zone = intent.getStringExtra("Zone")
        val Light =intent.getStringExtra("Light")
        val Price =intent.getStringExtra("Price")
        val Availabilty=intent.getStringExtra("Availabilty")
        val stringBuilder = StringBuilder()
        stringBuilder.append("Common: ${Common} \nBotanical:${Botanical} \nZone:${Zone} \nLight:${Light}" +
                "\nPrice:${Price} \nAvailabilty:${Availabilty} \n")
        text1.text=stringBuilder
    }
}