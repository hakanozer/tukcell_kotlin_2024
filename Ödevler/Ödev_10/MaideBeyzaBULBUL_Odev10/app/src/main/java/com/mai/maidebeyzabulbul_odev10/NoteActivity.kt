package com.mai.maidebeyzabulbul_odev10

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class NoteActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper
    private var userId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_note)

        dbHelper = DBHelper(this)

        val username = intent.getStringExtra("username")
        if (username != null) {
            userId = dbHelper.getUserId(username)
        }

        val titleEditText = findViewById<EditText>(R.id.note_title)
        val contentEditText = findViewById<EditText>(R.id.note_content)
        val addButton = findViewById<Button>(R.id.add_note_button)
        val searchEditText = findViewById<EditText>(R.id.search_note)
        val searchButton = findViewById<Button>(R.id.search_button)
        val notesListView = findViewById<ListView>(R.id.notes_list)

        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val content = contentEditText.text.toString()

            val noteId = dbHelper.insertNote(userId, title, content)
            if (noteId != -1L) {
                Toast.makeText(this, "Not eklendi", Toast.LENGTH_SHORT).show()
                loadNotes()
            } else {
                Toast.makeText(this, "Not eklenemedi", Toast.LENGTH_SHORT).show()
            }
        }

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            val notes = dbHelper.searchNotes(userId, query)
            val adapter = NoteAdapter(this, notes)
            notesListView.adapter = adapter
        }

        loadNotes()
    }

    private fun loadNotes() {
        val notes = dbHelper.getNotes(userId)
        val adapter = NoteAdapter(this, notes)
        findViewById<ListView>(R.id.notes_list).adapter = adapter
    }

}