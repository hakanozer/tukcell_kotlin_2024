package com.example.eray_altilar_odev_10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eray_altilar_odev_10.databinding.ActivityMainBinding
import com.example.eray_altilar_odev_10.presentation.homepage.HomepageActivity
import com.example.eray_altilar_odev_10.presentation.signup.SignUpActivity
import com.example.eray_altilar_odev_10.services.UserService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userService = UserService(this)

        binding.txtBtnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            finish()
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.editTxtUserNameLogin.text.toString()
            val password = binding.editTextPasswordLogin.text.toString()

            loginCheck(username, password)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun loginCheck(username: String, password: String) {
        var loginStatus = userService.singleUser(username, password)
        Log.d(getString(R.string.loginstatus), "$loginStatus")

        if (loginStatus != null) {
            val intent = Intent(this, HomepageActivity::class.java)
            Toast.makeText(this, getString(R.string.basarili_giris_yonlendiriliyorsunuz), Toast.LENGTH_SHORT).show()
            val getCurrentUserId = userService.singleUser(username, password)
            intent.putExtra(getString(R.string.userid_intent_key), getCurrentUserId!!.cid)
            finish()
            startActivity(intent)
        } else {
            Toast.makeText(this, getString(R.string.kullan_c_ad_veya_ifre_hatal), Toast.LENGTH_SHORT).show()
        }
    }
}