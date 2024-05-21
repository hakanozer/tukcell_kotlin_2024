package com.yeceylan.yunusemreceylan_snav3.presentation.spash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yeceylan.yunusemreceylan_snav3.R
import com.yeceylan.yunusemreceylan_snav3.presentation.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private val splashDisplayLength = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        enableEdgeToEdge()

        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, splashDisplayLength.toLong())
    }
}