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
import com.example.odev10.services.ContactServiceNotes

class UpdatePage : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var note:EditText
    lateinit var updateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_page)

        name=findViewById(R.id.updateName)
        note=findViewById(R.id.updateNote)
        updateButton=findViewById(R.id.update)

        val contactService=ContactServiceNotes(this)

        val id=intent.getIntExtra("noteId",-1)
        Log.d("güncel id",id.toString())

        updateButton.setOnClickListener {
            contactService.updateNotes(id,name.text.toString(),note.text.toString().toInt())
            val i= Intent(this,NoteActivity::class.java)
            startActivity(i)
        }

    }
}