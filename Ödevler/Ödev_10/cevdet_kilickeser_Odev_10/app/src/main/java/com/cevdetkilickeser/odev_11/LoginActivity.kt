package com.cevdetkilickeser.odev_11

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.cevdetkilickeser.odev_11.database.AppDatabase
import com.cevdetkilickeser.odev_11.databinding.ActivityLoginBinding
import com.cevdetkilickeser.odev_11.entity.User
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        db = AppDatabase.getDatabase(this)

        binding.buttonLogin.setOnClickListener {
            login()
        }

        binding.buttonSignup.setOnClickListener {
            signup()
        }

        setContentView(binding.root)
    }

    private suspend fun checkUser(email: String): User? {
        return db.getUserDao().checkUser(email)
    }

    private fun login() {

        lifecycleScope.launch {
            val email = binding.textEmail.text.toString()
            val password = binding.textPassword.text.toString()
            val user = withContext(Dispatchers.IO) {
                db.getUserDao().login(email, password)
            }


            user?.let {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("userId", it.id)
                startActivity(intent)
            } ?: run {
                closeKeyboard()
                Snackbar.make(binding.root, "Bilgilerinizi kontrol edin!", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun signup() {
        lifecycleScope.launch {
            val email = binding.textEmail.text.toString()
            val password = binding.textPassword.text.toString()

            if (email.isNotBlank() && password.isNotBlank()) {
                checkUser(email)?.let {
                    closeKeyboard()
                    Snackbar.make(binding.root, "Bu kullanıcı zaten var!", Snackbar.LENGTH_SHORT)
                        .show()
                } ?: run {
                    closeKeyboard()
                    val newUser = User(0, email, password)
                    db.getUserDao().signup(newUser)
                    Snackbar.make(
                        binding.root,
                        "Tebrikler! Giriş yapabilirsiniz.",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        view?.let {
            val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}