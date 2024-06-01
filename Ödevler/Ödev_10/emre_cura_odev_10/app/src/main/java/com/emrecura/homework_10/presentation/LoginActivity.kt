package com.emrecura.homework_10.presentation

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.emrecura.homework_10.R
import com.emrecura.homework_10.databinding.ActivityLoginBinding
import com.emrecura.homework_10.model.UserModel
import com.emrecura.homework_10.services.UserService

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var userService : UserService
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        userService = UserService(this)
        sharedPreferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE)


        binding.loginButton.setOnClickListener {
            login()
        }
        binding.loginKayTOlText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        login()
    }

    fun login() {
        val email = binding.loginEmailText.text.toString().trim()
        val password = binding.loginPasswordText.text.toString().trim()

        if (email.isNotEmpty() && password.isNotEmpty()) {

            val user = userService.authenticateUser(email, password)
            if (user != null) {
                saveUserToSharedPreferences(user)
                Toast.makeText(this, "Giriş başarılı!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email veya şifre yanlış.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
        }
    }
    // SharedPreferences'e kullanıcı bilgilerini kaydetme işlemi
    private fun saveUserToSharedPreferences(user: UserModel) {
        val editor = sharedPreferences.edit()
        editor.putInt("user_id", user.uid)
        editor.apply()
    }

}