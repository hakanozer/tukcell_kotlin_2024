package com.example.odev10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.odev10.config.AppDatabase
import com.example.odev10.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "pro1"
        ).build()

        binding.butonLogin.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                GlobalScope.launch(Dispatchers.IO) {
                    val user = db.userDao().getUser(username, password)
                    withContext(Dispatchers.Main) {
                        if (user != null && user.isRegister) {
                            Snackbar.make(binding.root, "Already logged i", Snackbar.LENGTH_SHORT).show()
                            Log.d("LoginActivity", "Already logged ")
                            val intent = Intent(this@LoginActivity, NoteActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else if (user != null && user.password == password) {
                            user.isRegister = true
                            db.userDao().updateUser(username, true)
                            Snackbar.make(binding.root, "Login Successfull", Snackbar.LENGTH_SHORT).show()
                            Log.d("LoginActivity", "Login Successful")
                            val intent = Intent(this@LoginActivity, NoteActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Snackbar.make(binding.root, "Invalid username or password", Snackbar.LENGTH_SHORT).show()
                            Log.d("LoginActivity", "Invalid username")
                        }
                    }
                }
            } else {
                Snackbar.make(binding.root, " fill in all fields", Snackbar.LENGTH_SHORT).show()
                Log.d("LoginActivity", " fill in all fields")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}