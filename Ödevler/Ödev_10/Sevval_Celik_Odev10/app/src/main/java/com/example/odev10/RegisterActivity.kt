package com.example.odev10

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.odev10.config.AppDatabase
import com.example.odev10.databinding.ActivityRegisterBinding
import com.example.odev10.entitie.User
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RegisterActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "pro1"
        ).build()

        binding.butonRegiste.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                GlobalScope.launch(Dispatchers.IO) {
                    val existingUser = db.userDao().getUser(username, password)
                    withContext(Dispatchers.Main) {
                        if (existingUser != null) {
                            Snackbar.make(binding.root, "Username already exists", Snackbar.LENGTH_SHORT).show()
                        } else {
                            val userDB = User(null, username = username, password = password)
                            db.userDao().insert(userDB)
                            Snackbar.make(binding.root, "Registration Successful", Snackbar.LENGTH_SHORT).show()
                            //Log.d("RegisterActivity", "Registration Successful")
                            val loginInt = Intent(this@RegisterActivity, LoginActivity::class.java)
                            startActivity(loginInt)
                            finish()
                        }
                    }
                }
            } else {
                Snackbar.make(binding.root, "Please fill in all fields", Snackbar.LENGTH_SHORT).show()
                //Log.d("RegisterActivity", "Please fill in all fields")
            }
        }

        binding.butonSignin.setOnClickListener {
            val loginInt = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(loginInt)
            finish()
        }
    }

}