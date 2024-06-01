package com.yeceylan.yunusemreceylan_odev10.presentation.register

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yeceylan.yunusemreceylan_odev10.R
import com.yeceylan.yunusemreceylan_odev10.databinding.ActivityRegisterBinding
import com.yeceylan.yunusemreceylan_odev10.model.entity.User
import com.yeceylan.yunusemreceylan_odev10.presentation.main.MainActivity
import com.yeceylan.yunusemreceylan_odev10.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()

            if (username.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()) {
                if (password == confirmPassword) {
                    userViewModel.getUserByUsername(username) { existingUser ->
                        if (existingUser != null) {
                            showErrorDialog(getString(R.string.username_already_exists))
                        } else {
                            val newUser = User(username, password)
                            userViewModel.insert(newUser) {
                                val intent = Intent(this, MainActivity::class.java)
                                intent.putExtra("username", username)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                } else {
                    binding.etPassword.error = getString(R.string.passwords_do_not_match)
                    binding.etConfirmPassword.error = getString(R.string.passwords_do_not_match)
                }
            } else {
                // Boş alanlar
                if (username.isBlank()) binding.etUsername.error = getString(R.string.username_cannot_be_empty)
                if (password.isBlank()) binding.etPassword.error = getString(R.string.password_cannot_be_empty)
                if (confirmPassword.isBlank()) binding.etConfirmPassword.error = getString(R.string.confirm_password_cannot_be_empty)
            }
        }
    }

    private fun showErrorDialog(message: String) {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.registration_error))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
