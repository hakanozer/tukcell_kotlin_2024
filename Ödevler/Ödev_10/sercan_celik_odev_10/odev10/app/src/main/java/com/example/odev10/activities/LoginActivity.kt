package com.example.odev10.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev10.R
import com.example.odev10.databinding.ActivityLoginBinding
import com.example.odev10.services.UserService

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var userService: UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userService = UserService(this)
        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = binding.etUsernameLogin.text.toString()
        val password = binding.etPasswordLogin.text.toString()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                this,
                "Do not leave username and password blank",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val loggedIn = userService.getSingleUser(username, password)
            if (loggedIn) {
                Toast.makeText(this, "Login Successful Welcome..", Toast.LENGTH_SHORT).show()
                splashAnimation()
            } else {
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }
    //Animasyon ve intent
    private fun splashAnimation() {
        binding.animationView.visibility = VISIBLE
        binding.btnLogin.visibility = GONE
        binding.tvLogin.visibility = GONE
        binding.etUsernameLogin.visibility = GONE
        binding.etPasswordLogin.visibility = GONE
        binding.imageView.visibility = GONE
        val timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
    //Herhangi bir yere tıklandığında klavyeyi kapat
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }


}