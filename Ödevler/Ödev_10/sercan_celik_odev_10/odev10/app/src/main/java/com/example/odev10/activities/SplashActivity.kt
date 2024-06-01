package com.example.odev10.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.odev10.services.UserService

class SplashActivity : AppCompatActivity() {

    private lateinit var db: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = UserService(this)

        val intent = if (db.isUserRegistered()) {
            Intent(this, LoginActivity::class.java)
        } else {
            Intent(this, OnboardingMainActivity::class.java)
        }
        startActivity(intent)
        finish()
    }

    override fun onResume() {
        super.onResume()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
