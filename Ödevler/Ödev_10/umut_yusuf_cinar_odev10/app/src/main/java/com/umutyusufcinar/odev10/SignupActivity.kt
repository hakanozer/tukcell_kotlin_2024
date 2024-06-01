//kayıt olma ekranı için activity
package com.umutyusufcinar.odev10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umutyusufcinar.odev10.R
import com.umutyusufcinar.odev10.configs.DB
import com.umutyusufcinar.odev10.databinding.ActivitySignupBinding
import com.umutyusufcinar.odev10.models.User
import com.umutyusufcinar.odev10.services.UserService

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var userService: UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userService = UserService(this)

        //kayıt butonu için listener
        binding.signUpButton.setOnClickListener {
            val username = binding.textUsername.text.toString()
            val password = binding.textPassword.text.toString()
            signUp(username, password)
        }

        binding.textviewLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    //signUp fonksiyonu ile alınan değerleri veri tabanına işleyeceğim
    private fun signUp(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) { //boş alan bırakılırsa toast ile uyarı
            Toast.makeText(this, "Lütfen Tüm Alanları Doldurun", Toast.LENGTH_SHORT).show()
            return
        }else{
            val user = User(id = 0, username = username, password = password)
            val effectRow = userService.addUser(user) //etkilenen satır kontrolü
            if (effectRow != -1L) {
                //İşlemin başarılı olduğuna dair toast mesajı gösteriyorum
                Toast.makeText(this, "Kullanıcı Kayıt İşlemi Başarılı!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                //işlem başarılı olmazsa toast mesajı
                Toast.makeText(this, "Kullanıcı Kaydedilemedi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}