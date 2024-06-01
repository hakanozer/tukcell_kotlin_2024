package com.example.emre_bitik_odev_10


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.emre_bitik_odev_10.services.ContactService




class MainActivity : AppCompatActivity() {
     lateinit var btnLogin: Button
     lateinit var txtUsername: EditText
     lateinit var txtPassword: EditText
     lateinit var btnSing: Button
    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        btnSing = findViewById(R.id.btnSing)
        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)

        val  contactService = ContactService(this)

        btnLogin.setOnClickListener {
            val status = contactService.singleUser(txtUsername.text.toString(), txtPassword.text.toString())

            if (status?.username==txtUsername.text.toString()&&status?.password==txtPassword.text.toString()){
                val intent = Intent(this, NoteActivity::class.java)

                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Hatalı Giriş",Toast.LENGTH_SHORT)
            }

        }
        btnSing.setOnClickListener() {

            val intent = Intent(this, SingActivity::class.java)
            startActivity(intent)
        }
    }
}