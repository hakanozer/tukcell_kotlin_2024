package com.aliberkaygedikoglu.odev10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliberkaygedikoglu.odev10.databinding.ActivityRegisterBinding
import com.aliberkaygedikoglu.odev10.entity.User
import com.aliberkaygedikoglu.odev10.room.DB

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val database = DB.getDatabase(this)
        binding.button.setOnClickListener {
            if (binding.editTextText.text.toString().isNotEmpty()&& binding.editTextText2.text.toString().isNotEmpty()){
                database?.usersDao()?.insert(User(null,binding.editTextText.text.toString(),binding.editTextText2.text.toString()))
                finish()
            }
        }

    }
}