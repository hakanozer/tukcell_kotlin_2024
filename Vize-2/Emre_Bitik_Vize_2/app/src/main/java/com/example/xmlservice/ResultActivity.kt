package com.example.xmlservice

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("DEPRECATION")
class ResultActivity : AppCompatActivity() {
   lateinit var txtResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        val gelenListe = intent.getSerializableExtra("plantList") as MutableList<String>?
        val gelenVeri = intent.getStringExtra("search")

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        txtResult = findViewById(R.id.txtResult)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val result = gelenListe?.find { it.equals(gelenVeri, ignoreCase = true) }
        txtResult.text = result

    }
}
