package com.example.odev10.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev10.R
import com.example.odev10.databinding.ActivityDetailBinding
import com.example.odev10.models.Note
import com.example.odev10.services.NoteService

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var noteService: NoteService
    private lateinit var note: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noteService = NoteService(this)
        note = intent.getSerializableExtra("note") as Note
        binding.noteTitle.setText(note.title)
        binding.noteContent.setText(note.content)

        binding.backButton.setOnClickListener {
            onBackPressed()
        }

        binding.deleteButton.setOnClickListener {
            showConfirmationDialog()
        }


        binding.editButton.setOnClickListener {
            val intent = Intent(this, UpdateActivity::class.java)
            intent.putExtra("note", note)
            startActivity(intent)
        }
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmation")
        builder.setMessage("Are you sure you want to delete this note?")
        builder.setPositiveButton("Yes") { _, _ ->
            deleteNote()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    private fun deleteNote() {
        noteService.deleteNote(note.nid)
        Toast.makeText(this, "Note deleted successfully.", Toast.LENGTH_SHORT).show()
        onBackPressed()
    }
}
