package com.example.odev5

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    var name="Shane Richar"
    var job="Photographer"
    var numberOfPhoto="98"
    var numberOfFollowers="10k"
    var numberOfFollowing="920"
    var buttonText=""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textDescription)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textUsername.text=name
        binding.textUserJob.text=job
        binding.textPhoto.text=numberOfPhoto
        binding.textFollowers.text=numberOfFollowers
        binding.textFollowing.text=numberOfFollowing

        binding.btnDetails.setOnClickListener {
            val i=Intent(this,OtherActivity::class.java)
            startActivity(i)
        }



    }
}