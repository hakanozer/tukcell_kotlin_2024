package com.ns.enesarisoy_odev11.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ns.enesarisoy_odev11.MainActivity
import com.ns.enesarisoy_odev11.R
import com.ns.enesarisoy_odev11.configs.UserOperations
import com.ns.enesarisoy_odev11.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val userOperations = UserOperations(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initClick()
    }

    private fun initClick() {
        with(binding) {
            llLogin.setOnClickListener {
                finish()
            }

            btnRegister.setOnClickListener {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                if (userOperations.checkUser(username)) {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Kullanıcı adı zaten mevcut",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }

                if (userOperations.registerUser(username, password) > 0) {
                    Toast.makeText(this@RegisterActivity, "Kayıt başarılı", Toast.LENGTH_SHORT)
                        .show()

                    userOperations.loginUser(username, password)?.let {
                        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                        intent.putExtra("USER_ID", it.id)
                        startActivity(intent)
                        finish()
                    }
                } else {
                    Toast.makeText(this@RegisterActivity, "Kayıt başarısız", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}