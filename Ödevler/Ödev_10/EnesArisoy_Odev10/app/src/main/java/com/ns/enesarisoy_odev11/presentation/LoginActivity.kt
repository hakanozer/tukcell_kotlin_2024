package com.ns.enesarisoy_odev11.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ns.enesarisoy_odev11.MainActivity
import com.ns.enesarisoy_odev11.R
import com.ns.enesarisoy_odev11.configs.UserOperations
import com.ns.enesarisoy_odev11.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var userOperations: UserOperations
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userOperations = UserOperations(this)

        initClick()
    }

    private fun initClick() {
        with(binding) {
            llRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }

            btnLogin.setOnClickListener {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                val user = userOperations.loginUser(username, password)
                if (user != null) {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("USER_ID", user.id)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Kullanıcı adı veya şifre yanlış",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            ivGoogle.setOnClickListener {
                Toast.makeText(this@LoginActivity, "Google ile giriş", Toast.LENGTH_SHORT).show()
            }

            ivApple.setOnClickListener {
                Toast.makeText(this@LoginActivity, "Apple ile giriş", Toast.LENGTH_SHORT).show()
            }

            tvForgotPassword.setOnClickListener {
                Toast.makeText(this@LoginActivity, "Not implemented..", Toast.LENGTH_SHORT).show()
            }
        }
    }
}