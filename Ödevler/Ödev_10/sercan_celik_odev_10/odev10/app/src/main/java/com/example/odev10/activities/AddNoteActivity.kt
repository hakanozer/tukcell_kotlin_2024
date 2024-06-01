package com.example.odev10.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev10.R
import com.example.odev10.databinding.ActivityAddNoteBinding
import com.example.odev10.services.NoteService

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding
    lateinit var noteService: NoteService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        noteService = NoteService(this)
        binding.btnUpdateNote.setOnClickListener {
            val noteTitle = binding.noteTitle.text.toString()
            val noteDescription = binding.noteContent.text.toString()
            if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                Toast.makeText(this, "Note added successfully.", Toast.LENGTH_SHORT).show()
                noteService.addNote(noteTitle, noteDescription)
                val intent = Intent()
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "Do not leave title and content blank", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        binding.backButton.setOnClickListener {
            onBackPressed()
        }

    }
}