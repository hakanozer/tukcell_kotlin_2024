package com.beyzaparlak.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.beyzaparlak.notesapp.configs.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var btn_login: Button
    private lateinit var txt_username: EditText
    private lateinit var txt_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // room
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "pro1"
        ).build()

        btn_login = findViewById(R.id.btn_login)
        txt_username = findViewById(R.id.txt_username)
        txt_password = findViewById(R.id.txt_password)

        // login buton click
        btn_login.setOnClickListener {
            val username = txt_username.text.toString()
            val password = txt_password.text.toString()
            // username ve password dolduruldu ise
            if (username.isNotEmpty() && password.isNotEmpty()) {
                GlobalScope.launch(Dispatchers.IO) {
                    val user = db.UsersDao().getUser(username, password)
                    withContext(Dispatchers.Main) {
                        if (user != null && user.isRegister) {
                            // Kullanıcı zaten giriş yapmışsa, tekrar giriş yapmasına gerek yok
                            Toast.makeText(this@LoginActivity, "Already logged in", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, NoteActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else if (user != null && user.password == password) {
                            // Giriş başarılı
                            user.isRegister = true
                            db.UsersDao().updateUser(username, true)
                            Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, NoteActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // Kullanıcı adı veya şifre hatalı
                            Toast.makeText(this@LoginActivity, "Invalid username or password", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                // Lütfen tüm alanları doldurun
                Toast.makeText(this@LoginActivity, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}