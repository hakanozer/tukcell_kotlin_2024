package com.example.odev_10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev_10.databinding.ActivityRegisterBinding
import com.example.odev_10.services.UserService

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userService = UserService(this)

        binding.btnBack.setOnClickListener{
            finish()
        }

        binding.btnSignIn2.setOnClickListener {
            finish()
        }

        binding.btnSignUp2.setOnClickListener {
            val username = binding.editTextUsername2.text.toString()
            val password = binding.editTextPassword2.text.toString()
            val confirmPassword = binding.editTextConfirmPassword.text.toString()
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please enter a username and password", Toast.LENGTH_SHORT).show()
            }
            else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
            }
            else if(!binding.termsCheckBox.isChecked) {
                Toast.makeText(this, "Please accept the terms and conditions", Toast.LENGTH_SHORT).show()
            }
            else if (userService.isUsernameExists(username)) {
                Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show()
            }
            else {
                userService.addUser(username, password)
                Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}