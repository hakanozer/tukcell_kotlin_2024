package com.ns.enesarisoy_vize3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.ns.enesarisoy_vize3.databinding.ActivityDetailBinding
import com.ns.enesarisoy_vize3.model.User

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user = intent.getSerializableExtra("user") as User
        binding.apply {
            tvName.text = user.firstName + " " + user.lastName
            tvEmail.text = user.email
            tvAddress.text = "${user.address?.address}, ${user.address?.city}, ${user.address?.state}"
            Glide.with(this@DetailActivity)
                .load(user.image)
                .into(ivUserImage)

            tvCompanyName.text = user.company?.name
            tvCompanyTitle.text = user.company?.title
            tvCompanyDepartment.text = user.company?.department
            tvCompanyLocation.text =
                "${user.company?.address?.address}, ${user.company?.address?.city}, ${user.company?.address?.state}"

            tvPhone.text = user.phone
            tvFullName.text = user.firstName + " " + user.lastName
            tvUsername.text = user.username
            tvGender.text = user.gender?.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase() else it.toString()
            }
            tvAge.text = user.age.toString()
            tvBirthday.text = user.birthDate
            tvBloodType.text = user.bloodGroup

            toolbarFilter.setNavigationOnClickListener {
                onBackPressed()
            }

        }
    }
}