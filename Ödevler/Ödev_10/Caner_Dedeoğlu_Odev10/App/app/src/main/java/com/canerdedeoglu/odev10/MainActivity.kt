package com.canerdedeoglu.odev10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.canerdedeoglu.odev10.models.User
import com.canerdedeoglu.odev10.services.NoteService
import com.canerdedeoglu.odev10.services.UserService

class MainActivity : AppCompatActivity() {

    private lateinit var loginEmailOrUserName: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var loginNewAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loginEmailOrUserName = findViewById(R.id.login_email)
        loginPassword = findViewById(R.id.login_password)
        loginButton = findViewById(R.id.login_button)
        loginNewAccount = findViewById(R.id.login_new_account)

        loginButton.setOnClickListener {
            val user =
                login(loginEmailOrUserName.text.toString(), loginPassword.text.toString(), this)
            if (user != null) {
                // Giriş başarılı olduğunda yönlendirme yap

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("userId", user.userId)
                startActivity(intent)

            }
        }
        loginNewAccount.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


    }

    private fun login(identifier: String, password: String, context: Context): User? {

        val userService = UserService(context)

        if (identifier.isNotEmpty() && password.isNotEmpty()) {

            val user = userService.getUser(identifier, password)

            if (user != null) {
                // Giriş başarılı
                Toast.makeText(
                    context,
                    "Giriş başarılı, hoş geldiniz ${user.name}!",
                    Toast.LENGTH_SHORT
                ).show()
                saveUserId(user.userId, context)
                return user
            } else {
                // Giriş başarısız
                Toast.makeText(context, "Kullanıcı adı veya şifre yanlış", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Toast.makeText(context, "Kullanıcı adı veya şifre boş olamaz", Toast.LENGTH_SHORT)
                .show()
        }

        return null
    }

    private fun saveUserId(userId: Int, context: Context) {
        val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putInt("USER_ID", userId).apply()
    }

}