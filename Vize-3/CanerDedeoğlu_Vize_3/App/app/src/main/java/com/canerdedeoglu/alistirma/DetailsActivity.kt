package com.canerdedeoglu.alistirma

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.canerdedeoglu.alistirma.models.EyeColor
import com.canerdedeoglu.alistirma.models.User
import com.canerdedeoglu.alistirma.service.IDummyService

class DetailsActivity : AppCompatActivity() {

    lateinit var txtUser: TextView
    lateinit var txtAge :TextView
    lateinit var txtGender :TextView
    lateinit var txtBirthday :TextView
    lateinit var txtEmail :TextView
    lateinit var txtPhone :TextView
    lateinit var txtBlood  :TextView
    lateinit var txtHair :TextView
    lateinit var txtEye :TextView
    lateinit var txtAddress :TextView
    lateinit var txtImage : ImageView
    lateinit var ImageBack2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtUser = findViewById(R.id.txtUser)
        txtAge = findViewById(R.id.txtAge)
        txtGender = findViewById(R.id.txtGender)
        txtBirthday = findViewById(R.id.txtBirthday)
        txtEmail = findViewById(R.id.txtEmail)
        txtPhone = findViewById(R.id.txtPhone)
        txtBlood = findViewById(R.id.txtBlood)
        txtHair = findViewById(R.id.txtHair)
        txtEye = findViewById(R.id.txtEye)
        txtImage = findViewById(R.id.userImage)
        txtAddress = findViewById(R.id.txtAdress)
        ImageBack2 = findViewById(R.id.imageBack2)
        // Get the user details from the intent
        val user = intent.getSerializableExtra("user") as User?
        user?.let {
            txtUser.text = "${it.firstName} ${it.lastName}"
            txtAge.text = it.age.toString()
            txtGender.text = it.gender.toString()
            txtBirthday.text = it.birthDate
            txtEmail.text = it.email
            txtPhone.text = it.phone
            txtBlood.text = it.bloodGroup
            txtHair.text = it.hair.color.toString()
            txtEye.text = it.eyeColor.toString()
            txtAddress.text = "${it.address.address} "
            Glide.with(this).load(it.image).into(txtImage)
        }

        ImageBack2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }



}