package com.example.homework10.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework10.R
import com.example.homework10.databinding.ActivityLoginScreenBinding
import com.example.homework10.models.User
import com.example.homework10.services.UserService

class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var userService:UserService



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginScreenBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userService=UserService(this)
        binding.btnEnter.setOnClickListener {
            val username=binding.editTextName.text.toString()
            val password=binding.editTextPassword.text.toString()
            val intent= Intent(this,HomeScreen::class.java)
            if (username.isNotEmpty()&&password.isNotEmpty()){
                val queryUserID=userService.getUser(username,password)
                if (queryUserID!=-1){
                    Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show()
                    intent.putExtra("userId",queryUserID.toInt())


                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this, "Böyle bir kullanıcı yok ,Kayıt Oluşturuluyor", Toast.LENGTH_SHORT).show()
                    val newUser=User(username = username, password = password)
                    val userId=userService.addUser(user = newUser)

                    if (userId != -1L) {
                        Toast.makeText(this, "Yeni Kullanıcı Eklendi", Toast.LENGTH_SHORT).show()
                        intent.putExtra("userId",userId.toInt())
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Kullanıcı eklenemedi", Toast.LENGTH_SHORT).show()
                    }

                }
            }
            else{
                Toast.makeText(this, "Lütfen boş değer girmeyiniz", Toast.LENGTH_SHORT).show()

            }



        }


    }
}