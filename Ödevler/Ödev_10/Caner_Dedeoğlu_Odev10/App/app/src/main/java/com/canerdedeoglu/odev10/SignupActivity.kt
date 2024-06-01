package com.canerdedeoglu.odev10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.canerdedeoglu.odev10.models.User
import com.canerdedeoglu.odev10.services.UserService

class SignupActivity : AppCompatActivity() {
    private lateinit var signupName: EditText
    private lateinit var signupSurname: EditText
    private lateinit var signupUsername: EditText
    private lateinit var signupEmail: EditText
    private lateinit var signupPassword: EditText
    private lateinit var signupConfirm: EditText
    private lateinit var signupButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        signupName = findViewById(R.id.signup_name)
        signupSurname = findViewById(R.id.signup_surname)
        signupUsername = findViewById(R.id.signup_username)
        signupEmail = findViewById(R.id.signup_email)
        signupPassword = findViewById(R.id.signup_password)
        signupConfirm = findViewById(R.id.signup_confirm)
        signupButton = findViewById(R.id.signup_button)

        signupButton.setOnClickListener {
            val name = signupName.text.toString()
            val surname = signupSurname.text.toString()
            val email = signupEmail.text.toString()
            val userName = signupUsername.text.toString()
            val password = signupPassword.text.toString()
            val confirm = signupConfirm.text.toString()

            if (password == confirm) {
                val user = addUser(name, surname, email, userName, password, this)
                if (user != null) {
                    // Kullanıcı başarıyla eklendi, burada diğer işlemleri yapabilirsiniz
                    Toast.makeText(this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show()
                    clearFields()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Password ve Confirm Password eşleşmiyor", Toast.LENGTH_SHORT).show()
            }


        }

    }
    private fun addUser(name: String, surname: String, email: String, userName: String, password: String, context: Context): User? {
        if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || userName.isEmpty() || password.isEmpty()) {
            when {
                name.isEmpty() -> Toast.makeText(context, "Name alanı boş olamaz", Toast.LENGTH_SHORT).show()
                surname.isEmpty() -> Toast.makeText(context, "Surname alanı boş olamaz", Toast.LENGTH_SHORT).show()
                email.isEmpty() -> Toast.makeText(context, "Email alanı boş olamaz", Toast.LENGTH_SHORT).show()
                userName.isEmpty() -> Toast.makeText(context, "Username alanı boş olamaz", Toast.LENGTH_SHORT).show()
                password.isEmpty() -> Toast.makeText(context, "Password alanı boş olamaz", Toast.LENGTH_SHORT).show()
            }
            return null
        }

        val userService = UserService(context)
        val userId = userService.addUser(name, surname, email, userName, password)

        return if (userId > 0) {
            Toast.makeText(context, "Kullanıcı başarıyla eklendi", Toast.LENGTH_SHORT).show()
            User(userId.toInt(), name, surname, email, userName, password) // User modelini oluşturun ve döndürün
        } else {
            Toast.makeText(context, "Kullanıcı eklenirken bir hata oluştu", Toast.LENGTH_SHORT).show()
            null
        }
    }
    private fun clearFields() {
        signupName.text.clear()
        signupSurname.text.clear()
        signupUsername.text.clear()
        signupEmail.text.clear()
        signupPassword.text.clear()
        signupConfirm.text.clear()
    }
}