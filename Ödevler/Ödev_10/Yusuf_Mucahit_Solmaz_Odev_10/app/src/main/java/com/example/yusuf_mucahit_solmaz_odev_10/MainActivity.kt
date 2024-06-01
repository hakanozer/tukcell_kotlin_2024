package com.example.yusuf_mucahit_solmaz_odev_10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yusuf_mucahit_solmaz_odev_10.databinding.ActivityMainBinding
import com.example.yusuf_mucahit_solmaz_odev_10.db.service.UserService
import com.example.yusuf_mucahit_solmaz_odev_10.ui.NoteActivity
import com.example.yusuf_mucahit_solmaz_odev_10.ui.SignupActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactService= UserService(this)

        binding.signUpButton.setOnClickListener {
            val i=Intent(this, SignupActivity::class.java)
            startActivity(i)
        }

        binding.signinButton.setOnClickListener {
           val user = contactService.matchUser(binding.loginName.text.toString(),binding.loginPassword.text.toString())
            if (user !=null){
                val intent=Intent(this, NoteActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Username or password is wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}