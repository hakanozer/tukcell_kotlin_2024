package com.example.emre_bitik_odev_10

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.emre_bitik_odev_10.services.ContactService

class SingActivity : AppCompatActivity() {
    lateinit var btnSinging: Button
    lateinit var txtUsernamesing: TextView
    lateinit var txtPasswordsing: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sing)
        txtUsernamesing = findViewById(R.id.txtUsernamesing)
        txtPasswordsing = findViewById(R.id.txtPasswordsing)
        btnSinging = findViewById(R.id.btnSinging)
        val  contactService = ContactService(this)

        btnSinging.setOnClickListener() {
            contactService.addUSer(txtUsernamesing.text.toString(),txtPasswordsing.text.toString())// ekleme

            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

    }
}