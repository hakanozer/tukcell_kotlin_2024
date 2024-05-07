package com.example.exercise4

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exercise4.databinding.ActivityMainBinding
import com.example.exercise4.databinding.ActivityOtherBinding
import java.io.Serializable

class Other : AppCompatActivity() {
    lateinit var binding:ActivityOtherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

// Bulunan ilk örneğin alınması ve yazdırılması
        val common=intent.getSerializableExtra("serializable") as  Plant
        Log.d("common",common.toString())
        binding.textCommon.text=common.common.toString()
        binding.textBotanical.text=common.botanical.toString()
        binding.textZone.text=common.zone.toString()
        binding.textLight.text=common.light.toString()
        binding.textPrice.text=common.price.toString()
        binding.textAvailability.text=common.availability.toString()






    }
}