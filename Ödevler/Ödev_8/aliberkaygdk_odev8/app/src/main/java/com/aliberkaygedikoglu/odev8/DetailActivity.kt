package com.aliberkaygedikoglu.odev8

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliberkaygedikoglu.odev8.databinding.ActivityDetailBinding
import com.aliberkaygedikoglu.odev8.databinding.ActivityMainBinding
import com.aliberkaygedikoglu.odev8.model.Recipe
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val i = intent.getSerializableExtra("detail",Recipe::class.java)
        Glide
            .with(this)
            .load(i?.image)
            .centerCrop()
            .into(binding.imageView);


        binding.textView.setText(i?.name)
        binding.textViewIngredients.setText("Ingredients:\n${i?.ingredients?.joinToString (",") } ")
        binding.textViewIntro.text = "Instructions:\n${i?.instructions?.joinToString ("\n") } "

    }
}