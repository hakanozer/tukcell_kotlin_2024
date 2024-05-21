package com.bengisusahin.vize03_calisma.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bengisusahin.vize03_calisma.R
import com.bengisusahin.vize03_calisma.databinding.ActivityDetailBinding
import com.bengisusahin.vize03_calisma.models.User
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val detail = intent.getSerializableExtra("userDetail") as User
        // Thanks to apply func it accessed all properties of binding.
        binding.apply {
            txtViewUsername.text = detail.username
            txtViewFirstName.text = detail.firstName
            txtViewLastName.text = detail.lastName
            txtViewMaidenNameContent.text = detail.maidenName
            txtViewAgeContent.text = "${detail.age}"
            txtViewGenderContent.text = "${detail.gender}"
            txtViewEmailContent.text = detail.email
            txtViewPhoneContent.text = detail.phone
            txtViewBirthDateContent.text = detail.birthDate
            txtViewBloodGroupContent.text = detail.bloodGroup
            txtViewHeightContent.text = detail.height.toString()
            txtViewWeightContent.text = detail.weight.toString()
            txtViewHairColorContent.text = detail.hair.color.toString()
            txtViewHairTypeContent.text = detail.hair.type.toString()
            Glide.with(this@DetailActivity)
                .load(detail.image)
                .into(imageView)
        }
    }
}