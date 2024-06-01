package com.yeceylan.yunusemreceylan_odev10.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yeceylan.yunusemreceylan_odev10.R
import com.yeceylan.yunusemreceylan_odev10.databinding.ActivityLoginBinding
import com.yeceylan.yunusemreceylan_odev10.presentation.main.MainActivity
import com.yeceylan.yunusemreceylan_odev10.presentation.register.RegisterActivity
import com.yeceylan.yunusemreceylan_odev10.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            userViewModel.getUser(username, password) { user ->
                if (user != null) {
                    // Kullanıcı mevcutsa, ana sayfaya yönlendirin
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    finish()
                } else {
                    // Kullanıcı mevcut değilse, hata mesajı gösterin
                    showErrorDialog()
                }
            }
        }

        binding.btnRegister.setOnClickListener {
            // Register sayfasına yönlendirin
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.login_error))
            .setMessage(getString(R.string.user_not_found_do_you_want_to_register))
            .setPositiveButton(getString(R.string.register)) { dialog, _ ->
                dialog.dismiss()
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
