package com.example.mustafakocerodev10.activitiy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.mustafakocerodev10.R
import com.example.mustafakocerodev10.config.AppDatabase
import com.example.mustafakocerodev10.dao.UserDao
import com.example.mustafakocerodev10.databinding.ActivityMainBinding
import com.example.mustafakocerodev10.entity.User
import com.example.mustafakocerodev10.staticVariable.staticVars

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "notes_app_database"
        ).build()

        userDao = db.createUserDao()

        binding.btnLogin.setOnClickListener {
            val run = Runnable {
                signControl()
            }
            Thread(run).start()
        }

        binding.btnRegister.setOnClickListener {
            val run = Runnable {
                registerControl()
            }
            Thread(run).start()
        }


    }// END OF onCreate

    fun registerControl() {
        val passwd = binding.edtTxtPasswd.text.toString()
        val username = binding.edtTxtUsername.text.toString()
        if (passwd.isNotBlank() and username.isNotBlank()) {
            val haveAcc = userDao.getOneUserByUsername(username)
            if (haveAcc == null) {
                // kullanici kayitli degil, kayit et
                val newUser = User(null, username, passwd)
                val id = userDao.insertUser(newUser)
                staticVars.uid = id.toInt()
                // böylece kayıt yapan kullanıcının id'sine tüm programdan ulaşabilirim
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)

            } else {
                showToast("This user is exist. Please take a different username!")
            }

        } else {
            showToast("Username or password cant be empty!")
        }

    }

    fun signControl() {
        val passwd = binding.edtTxtPasswd.text.toString()
        val username = binding.edtTxtUsername.text.toString()
        if (passwd.isNotBlank() and username.isNotBlank()) {
            val haveAcc = userDao.getOneUserByUsername(username)
            if (haveAcc != null) {
                // hesabi var demek bilgilerini kontrol etmem lazım
                if (haveAcc.userName.equals(username) and haveAcc.password.equals(passwd)) {
                    // eslesti, giris yapti
                    val intent = Intent(this@MainActivity, LoginActivity::class.java)
                    staticVars.uid = haveAcc.uid!!.toInt()
                    startActivity(intent)
                } else {
                    showToast("Username or password is mistaken!")
                }
            } else {
                showToast("Please register first!")
            }

        } else {
            showToast("Username or password cant be empty!")
        }

    }


    fun showToast(text: String) {
        runOnUiThread {
            Toast.makeText(
                this@MainActivity,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}// END OF MainActivity