package com.mai.maidebeyzabulbul_odev5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btnGoToDetail : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToDetail = findViewById(R.id.GoToDetail)


        btnGoToDetail.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java)
            startActivity(i)
        }

    }

}