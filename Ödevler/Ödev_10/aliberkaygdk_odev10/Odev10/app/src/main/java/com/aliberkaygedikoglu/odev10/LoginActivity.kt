package com.aliberkaygedikoglu.odev10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliberkaygedikoglu.odev10.databinding.ActivityLoginBinding
import com.aliberkaygedikoglu.odev10.entity.User
import com.aliberkaygedikoglu.odev10.room.DB

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
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
        val database = DB.getDatabase(this)

        binding.buttonRegister.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.buttonLogin.setOnClickListener {

            val userDB=
                database?.usersDao()?.getUser(binding.editTextUsername.text.toString(),binding.editTextPassw.text.toString())

            if (userDB ==null){
                Toast.makeText(this@LoginActivity,"Hatalı giriş",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                intent.putExtra("user",userDB)
                startActivity(intent)
                finish()
            }

        }
    }
}