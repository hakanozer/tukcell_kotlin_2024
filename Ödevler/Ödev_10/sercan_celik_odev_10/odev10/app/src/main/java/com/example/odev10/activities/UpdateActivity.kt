package com.example.odev10.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev10.R
import com.example.odev10.databinding.ActivityUpdateBinding
import com.example.odev10.models.Note
import com.example.odev10.services.NoteService

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var noteService: NoteService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        noteService = NoteService(this)
        val note = intent.getSerializableExtra("note") as Note
        binding.noteTitle.setText(note.title)
        binding.noteContent.setText(note.content)
        binding.btnUpdateNote.setOnClickListener {
            if (binding.noteTitle.text.isNotEmpty() && binding.noteContent.text.isNotEmpty()) {
                noteService.updateNote(
                    binding.noteTitle.text.toString(),
                    binding.noteContent.text.toString(),
                    note.nid
                )
                Intent(this, MainActivity::class.java).apply {
                    startActivity(this)
                }
                Toast.makeText(this, "Note updated successfully.", Toast.LENGTH_SHORT).show()
                onBackPressed()

            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }

        }
        binding.backButton.setOnClickListener {
            onBackPressed()
        }


    }


}