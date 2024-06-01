package com.example.eray_altilar_odev_10.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eray_altilar_odev_10.MainActivity
import com.example.eray_altilar_odev_10.R
import com.example.eray_altilar_odev_10.databinding.ActivitySignUpBinding
import com.example.eray_altilar_odev_10.presentation.homepage.HomepageActivity
import com.example.eray_altilar_odev_10.services.UserService

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        userService = UserService(this)

        binding.btnSignUp.setOnClickListener {
            val username = binding.editTxtUserNameSignUp.text.toString()
            val password = binding.editTextPasswordSignUp.text.toString()
            val confirmPassword = binding.editTextPasswordConfirmSignUp.text.toString()
            val isPasswordMatch = binding.txtCheckPasswordMatch

            userService.getAllUsers().forEach {
                val userNames = it.userName

                if (password != confirmPassword) {
                    Toast.makeText(this, R.string.passwords_doesn_t_match, Toast.LENGTH_SHORT).show()
                    isPasswordMatch.text = getString(R.string.passwords_doesn_t_match)

                } else if (userNames.contains(username)) {
                    Toast.makeText(this, R.string.username_already_exists, Toast.LENGTH_SHORT).show()
                    isPasswordMatch.text = getString(R.string.username_already_exists)
                } else {
                    val addUserStatus = userService.addUser(username, password)
                    isPasswordMatch.text = ""
                    Log.d(getString(R.string.adduser), "$addUserStatus")
                    val intent = Intent(this, HomepageActivity::class.java)
                    finish()
                    startActivity(intent)
                }
            }
        }
    }
}