package com.example.emre_bitik_odev_10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.emre_bitik_odev_10.services.ContactService

class DetailActivity : AppCompatActivity() {
    lateinit var btnSave : Button
    lateinit var btnDelete : Button
    lateinit var txtUtitle : EditText
    lateinit var txtUdetail : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        btnSave = findViewById(R.id.btnSave)
        btnDelete = findViewById(R.id.btnDelete)
        txtUtitle = findViewById(R.id.txtUtitle)
        txtUdetail = findViewById(R.id.txtUdetail)

        val  contactService = ContactService(this)

        txtUtitle.setText(intent.getStringExtra("title"))
        txtUdetail.setText(intent.getStringExtra("detail"))

        btnSave.setOnClickListener{

                contactService.addContact(txtUtitle.text.toString(),txtUdetail.text.toString())
                val intent = Intent(this, NoteActivity::class.java)
                startActivity(intent)

        }
        val cid = intent.getIntExtra("cid", -1)

        btnDelete.setOnClickListener{
            val intent = Intent(this, NoteActivity::class.java)

            startActivity(intent)
            contactService.deleteContact(cid)
        }

    }
}