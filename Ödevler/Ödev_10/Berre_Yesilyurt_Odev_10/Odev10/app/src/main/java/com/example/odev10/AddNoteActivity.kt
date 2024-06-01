package com.example.odev10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev10.services.ContactServiceNotes

class AddNoteActivity : AppCompatActivity() {
    lateinit var lesson:EditText
    lateinit var note:EditText
    lateinit var add: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        lesson=findViewById(R.id.addLessonName)
        note=findViewById(R.id.addNote)
        add=findViewById(R.id.addButton)


        val contactService=ContactServiceNotes(this)

        add.setOnClickListener {
            contactService.addNote(lesson.text.toString(),note.text.toString().toInt())
            val i= Intent(this,NoteActivity::class.java)
            startActivity(i)
        }

    }
}