package com.bengisusahin.odev_10.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bengisusahin.odev_10.R
import com.bengisusahin.odev_10.databinding.ActivityLoginBinding
import com.bengisusahin.odev_10.services.UserService

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userService: UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userService = UserService(this)

        binding.loginButton.setOnClickListener {
            val username = binding.textUsername.text.toString()
            val password = binding.textPassword.text.toString()
            login(username, password)
        }
        // go to the signup activity when the user clicks the sign up text
        binding.textviewSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            // because the user can go back to the login activity if they press the back button, we don't need to finish the activity
        }
    }

    // login function checks if the user exists in the database
    private fun login(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }else {
            val user = userService.getUser(username, password)
            if (user != null) {
                // user exists
                // go to the main activity
                Toast.makeText(this, "User logged in successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("userId", user.id)
                startActivity(intent)
                finish()
            } else {
                // user does not exist
                // show a toast message
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }
}