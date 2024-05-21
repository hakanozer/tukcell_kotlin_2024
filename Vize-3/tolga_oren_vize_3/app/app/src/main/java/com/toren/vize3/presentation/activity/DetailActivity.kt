package com.toren.vize3.presentation.activity

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.toren.vize3.R
import com.toren.vize3.data.dto.User
import com.toren.vize3.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val arg = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("user", User::class.java)
        } else {
            intent.getSerializableExtra("user") as User
        }

        arg?.let {
            loadRecipeDetails(it)
        }

    }

    fun loadRecipeDetails(user: User) {
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(user.image)
                .into(imageView)
            dNameTw.text = "${user.firstName} ${user.lastName}"
            dEmailTw.text = user.email
            dPhoneTw.text = user.phone
            dHeightTw.text = "${user.height} cm"
            dWeightTw.text = "${user.weight} kg"
            dAgeTw.text = "${user.age} y.o."
            dbirthDayTw.text = user.birthDate
            dGenderTw.text = user.gender
            dHairColorTw.text = "Hair Color: ${user.hair.color}"
            dEyeColorTw.text = "Eye Color: ${user.eyeColor}"
            dBloodColorTw.text = user.bloodGroup
            dTitleTw.text = user.company.title
            dCompanyTw.text = user.company.name
            dAdressTw.text = "${user.address.address} ${user.address.city}"
            dPhoneTw.text = user.phone
            dEmailTw.text = user.email

        }
    }



}