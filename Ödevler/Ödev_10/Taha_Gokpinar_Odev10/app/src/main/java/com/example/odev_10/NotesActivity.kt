package com.example.odev_10

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev_10.adaptors.NotesAdaptor
import com.example.odev_10.databinding.ActivityNotesBinding
import com.example.odev_10.models.Note
import com.example.odev_10.services.NoteService

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding
    private lateinit var notesList : MutableList<Note>
    private lateinit var adapter : NotesAdaptor
    private lateinit var noteService : NoteService
    private var userId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNotesBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userId = intent.getIntExtra("userId", 0)

        noteService = NoteService(this)
        notesList = mutableListOf()
        adapter = NotesAdaptor(this, notesList)
        binding.listViewNotes.adapter = adapter

        loadNotes()

        binding.btnAddNote.setOnClickListener {
            val intent = Intent(this, AddNote::class.java)
            intent.putExtra("userId", userId)
            startActivity(intent)
        }

        binding.btnSearch.setOnClickListener {
            val query = binding.editTextSearch.text.toString()
            searchNotes(query)
        }
    }

    override fun onResume() {
        super.onResume()
        loadNotes()
    }

    fun loadNotes() {
        notesList.clear()
        notesList.addAll(noteService.getAllNotes(userId))
        adapter.notifyDataSetChanged()
    }

    private fun searchNotes(query: String) {
        notesList.clear()
        notesList.addAll(noteService.searchNotes(userId, query))
        adapter.notifyDataSetChanged()
    }
}
