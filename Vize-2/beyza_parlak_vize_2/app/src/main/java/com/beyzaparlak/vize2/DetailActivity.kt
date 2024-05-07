package com.beyzaparlak.vize2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.beyzaparlak.vize2.R
import com.beyzaparlak.vize2.databinding.ActivityDetailBinding
import com.beyzaparlak.vize2.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    // --- binding ---
    lateinit var binding: ActivityDetailBinding
    lateinit var textView2: TextView
    lateinit var btnBack: ImageView

    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        textView2 = binding.textView2
        btnBack = binding.btnBack

        // back butona basılırsa
        btnBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        val Common = intent.getStringExtra("COMMON")
        val Botanical = intent.getStringExtra("BOTANICAL")
        val Zone = intent.getStringExtra("ZONE")
        val Light =intent.getStringExtra("LIGTH")
        val Price =intent.getStringExtra("PRICE")
        val Availabilty=intent.getStringExtra("AVAILABILITY")
        val stringBuilder = StringBuilder()

        // gelen detayları yazdırıyorum
        stringBuilder.append("COMMON: ${Common} \n" +
                "BOTANICAL:${Botanical}         \n" +
                "ZONE : ${Zone}                 \n" +
                "LIGTH : ${Light}               \n" +
                "PRICE : ${Price}               \n" +
                "AVAILABILITY : ${Availabilty}  \n")

        textView2.text = stringBuilder


    }
}