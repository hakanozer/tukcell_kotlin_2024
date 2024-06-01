package com.emrecura.homework_10.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.emrecura.homework_10.R
import com.emrecura.homework_10.databinding.ActivityRegisterBinding
import com.emrecura.homework_10.services.UserService

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userService :UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        userService = UserService(this)
        binding.registerButton.setOnClickListener {
            register()
        }
        binding.registerGirisYapText.setOnClickListener {
            finish()
        }
    }


    private fun register() {
        val email = binding.registerEmailText.text.toString().trim()
        val username = binding.registerUsernameText.text.toString().trim()
        val password = binding.registerPasswordText.text.toString().trim()

        if (email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
            val result = userService.addUser(email, username, password)
            if (result > 0) {
                Toast.makeText(this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Kayıt başarısız, tekrar deneyin.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
        }

    }
}