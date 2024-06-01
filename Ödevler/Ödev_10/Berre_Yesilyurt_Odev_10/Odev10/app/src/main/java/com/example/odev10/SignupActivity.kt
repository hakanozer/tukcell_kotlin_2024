package com.example.odev10

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.odev10.services.ContactServiceUser

class SignupActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var password:EditText
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_activity)
        name=findViewById(R.id.nameSignupPage)
        password=findViewById(R.id.passwordSignupPage)
        button=findViewById(R.id.signupButtonSignupPage)

        val contactServiceUser=ContactServiceUser(this)

        button.setOnClickListener {
            val status=contactServiceUser.addUser(name.text.toString(),password.text.toString())
            Log.d("Kayıt olundu mu",status.toString())

        }



    }
}