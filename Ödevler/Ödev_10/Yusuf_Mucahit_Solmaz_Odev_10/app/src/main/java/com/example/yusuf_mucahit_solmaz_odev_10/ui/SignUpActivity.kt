package com.example.yusuf_mucahit_solmaz_odev_10.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yusuf_mucahit_solmaz_odev_10.databinding.SignUpActivityBinding
import com.example.yusuf_mucahit_solmaz_odev_10.db.service.UserService

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: SignUpActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactServiceUser= UserService(this)

        binding.signUpBtn.setOnClickListener {
            contactServiceUser.addUser(binding.userNameSignUp.text.toString(),binding.passwordSignUp.text.toString())

            val intent= Intent(this, NoteActivity::class.java)
            startActivity(intent)
        }



    }
}