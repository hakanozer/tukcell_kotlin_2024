//giriş ekranı için activity
package com.umutyusufcinar.odev10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umutyusufcinar.odev10.R
import com.umutyusufcinar.odev10.databinding.ActivityLoginBinding
import com.umutyusufcinar.odev10.services.UserService

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userService: UserService
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

        userService = UserService(this)

        //giriş için login butonuna listener
        binding.loginButton.setOnClickListener {
            val username = binding.textUsername.text.toString()
            val password = binding.textPassword.text.toString()
            login(username, password)
        }
        //Kullanıcı kayıt metnine tıkladığında sayfa geçişi
        binding.textviewSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            //kullanıcı geri düğmesine bastığında oturum açma etkinliğine geri dönebileceğinden, activity'i bitirmiyorum
        }
    }

    //login fonksiyonu alanların doldurulup doldurulmadığını ve
    //kullanıcının db içerisinde olup olmadığını kontrol ediyor
    private fun login(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            //boş bırakılan bir alan varsa toast ile uyarı
            Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
            return
        }else {
            val user = userService.getUser(username, password)
            if (user != null) {
                Toast.makeText(this, "Kullanıcı Girişi Başarılı!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("userId", user.id)
                startActivity(intent)
                finish()
            } else { //Db de bulunamazsa toast ile uyarı gösteriyorum
                Toast.makeText(this, "Kullanıcı Adı veya Parola Yanlış!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}