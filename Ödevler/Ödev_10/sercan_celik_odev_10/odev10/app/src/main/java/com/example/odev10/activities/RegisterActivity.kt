package com.example.odev10.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev10.R
import com.example.odev10.databinding.ActivityRegisterBinding
import com.example.odev10.services.UserService

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userService: UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        userService = UserService(this)

        binding.btnRegister.setOnClickListener {
            register()
        }
    }

    private fun register() {
        if (binding.etUsernameRegister.text.isEmpty() || binding.etPasswordRegister.text.isEmpty()) {
            Toast.makeText(this, "Fill in the username and password.", Toast.LENGTH_SHORT)
                .show()

        } else {
            userService.addUser(
                binding.etUsernameRegister.text.toString(),
                binding.etPasswordRegister.text.toString()
            )
            Toast.makeText(this, "Registration successful logining..", Toast.LENGTH_SHORT).show()
            splashAnimation()
        }

    }

    //Animasyon ve intent
    private fun splashAnimation() {
        binding.animationView.visibility = View.VISIBLE
        binding.btnRegister.visibility = View.GONE
        binding.tvRegister.visibility = View.GONE
        binding.etUsernameRegister.visibility = View.GONE
        binding.etPasswordRegister.visibility = View.GONE
        binding.imageView.visibility = View.GONE
        val timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
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