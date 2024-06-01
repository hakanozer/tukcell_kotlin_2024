package com.example.odev10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev10.services.ContactServiceUser

class MainActivity : AppCompatActivity() {
    lateinit var signupButton: Button
    lateinit var signinButton:Button
    lateinit var name:EditText
    lateinit var password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signupButton=findViewById(R.id.signUpButton)
        signinButton=findViewById(R.id.signinButton)
        name=findViewById(R.id.nameHomePage)
        password=findViewById(R.id.passwordHomePage)

        val contactService=ContactServiceUser(this)

        signupButton.setOnClickListener {
            val i=Intent(this,SignupActivity::class.java)
            startActivity(i)
        }

        signinButton.setOnClickListener {
            val isThereUser=contactService.matchUser(name.text.toString(),password.text.toString())
            Log.d("Kullanıcı Kayıtlı Mı",isThereUser.toString())

            isThereUser?.let { // Kullanıcı kayıtlıysa note sayfasına gidebilsin
                val i=Intent(this,NoteActivity::class.java)
                startActivity(i)
            }

        }

        //contactService.deleteUser(2)

        val userList=contactService.listUsers()

        Log.d("Kullanıcı Listesi",userList.toString())
    }
}