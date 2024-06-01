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
import com.beyzaparlak.notesapp.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    lateinit var btn_register: Button
    lateinit var btn_signin: Button
    lateinit var txtUsername: EditText
    lateinit var txtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // room
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "pro1"
        ).build()

        btn_register = findViewById(R.id.btn_register)
        btn_signin = findViewById(R.id.btn_signin)
        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)

        // sign in butona tıklandığında
        btn_register.setOnClickListener {
            val username = txtUsername.text.toString()
            val password = txtPassword.text.toString()
            // username ve password dolduruldu ise
            if (username.isNotEmpty() && password.isNotEmpty()) {
                GlobalScope.launch(Dispatchers.IO) {
                    val existingUser = db.UsersDao().getUser(username, password)
                    if (existingUser != null) {
                        // Kullanıcı zaten varsa, kayıt yapma
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@RegisterActivity, "Username already exists", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // Yeni kullanıcı oluştur
                        val user = User(null, username = username, password = password)
                        db.UsersDao().insert(user)
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@RegisterActivity, "Registration Successful", Toast.LENGTH_SHORT).show()
                            val loginIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
                            startActivity(loginIntent)
                            finish()
                        }
                    }
                }
            } else {
                // Lütfen tüm alanları doldurun
                Toast.makeText(this@RegisterActivity, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // sign in butonuna tıklandığında
        btn_signin.setOnClickListener {
            val loginIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(loginIntent)
            finish()
        }
    }
}