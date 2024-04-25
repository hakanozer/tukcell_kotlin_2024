package com.works.days_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.days_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtName.setText("New Data")

        binding.btnSend.setOnClickListener {
            val i = Intent(this, ProfileActivity::class.java )
            i.putExtra("dataKey", binding.txtName.text.toString())
            startActivity(i)
            // finish() // bu nesneyi öldür
        }
        //binding.btnSend.setOnClickListener(clickBtn)
    }

    val clickBtn = View.OnClickListener { }

}