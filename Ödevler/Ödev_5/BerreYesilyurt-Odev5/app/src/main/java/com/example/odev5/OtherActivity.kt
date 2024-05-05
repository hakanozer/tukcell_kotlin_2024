package com.example.odev5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev5.databinding.ActivityOtherBinding

class OtherActivity : AppCompatActivity() {

    private lateinit var binding:ActivityOtherBinding

    var name="Tanya Nguyen"
    var city="London, UK"
    val description="Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in" +
            "a piece of classical latin."

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityOtherBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textDescription)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textName.text=name
        binding.textCity.text=city
        binding.textDescription.text=description


    }
}