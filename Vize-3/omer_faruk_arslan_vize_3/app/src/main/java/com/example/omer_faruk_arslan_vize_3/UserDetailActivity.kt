package com.example.omer_faruk_arslan_vize_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.bumptech.glide.Glide

class UserDetailActivity : AppCompatActivity() {

    lateinit var btnBack : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val hairType = intent.getStringExtra("hairType")
        val bloodGroup = intent.getStringExtra("bloodGroup")


        findViewById<ImageView>(R.id.btnBack)
        findViewById<TextView>(R.id.txtName).text = "Name: $name"
        findViewById<TextView>(R.id.txtAge).text = "Age: $age"
        findViewById<TextView>(R.id.txtHairType).text = "Hair Type: $hairType"
        findViewById<TextView>(R.id.txtBloodGroup).text = "Blood Group: $bloodGroup"
        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener { val i = Intent(this, MainActivity::class.java)
            startActivity(i) }

    }
}
