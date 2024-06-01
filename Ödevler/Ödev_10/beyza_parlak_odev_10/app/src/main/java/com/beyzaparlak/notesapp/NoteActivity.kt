package com.beyzaparlak.notesapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.beyzaparlak.notesapp.adapters.NoteAdapter
import com.beyzaparlak.notesapp.configs.AppDatabase
import com.beyzaparlak.notesapp.entities.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NoteActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchQuery: EditText
    private lateinit var btnSearch: Button
    private lateinit var btnAddNote: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "pro1"
        ).build()

        searchQuery = findViewById(R.id.searchQuery)
        btnSearch = findViewById(R.id.btn_search)
        btnAddNote = findViewById(R.id.btn_add_note)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        noteAdapter = NoteAdapter(mutableListOf(), ::showNoteDialog, ::deleteNote)
        recyclerView.adapter = noteAdapter

        loadAllNotes()
        // search butona tıklandığında
        btnSearch.setOnClickListener {
            val query = searchQuery.text.toString()
            if (query.isNotEmpty()) {
                searchNotes(query)
            } else {
                loadAllNotes()
            }
        }
        // add note butona tıklandığında
        btnAddNote.setOnClickListener {
            showNoteDialog(null)
        }
    }

    // tüm notları recyclerview e yükler
    private fun loadAllNotes() {
        GlobalScope.launch(Dispatchers.IO) {
            val notes = db.NotesDao().getAll()
            withContext(Dispatchers.Main) {
                noteAdapter.updateNotes(notes)
            }
        }
    }

    // notlar üzerinde arama işlemi yapar. title ya da detaile göre
    private fun searchNotes(query: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val notes = db.NotesDao().searchByTitleOrDetail("%$query%")
            withContext(Dispatchers.Main) {
                noteAdapter.updateNotes(notes)
            }
        }
    }

    private fun showNoteDialog(note: Note?) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_note, null)
        val etTitle = dialogView.findViewById<EditText>(R.id.etTitle)
        val etDetail = dialogView.findViewById<EditText>(R.id.etDetail)

        // note boş değilse, title ve detail değerlerini doldurur
        note?.let {
            etTitle.setText(it.title)
            etDetail.setText(it.detail)
        }
        // note null ise add note not null ise update olarak algılar
        AlertDialog.Builder(this)
            .setTitle(if (note == null) "Add Note" else "Update Note")
            .setView(dialogView)
            .setPositiveButton(if (note == null) "Add" else "Update") { _, _ ->
                val title = etTitle.text.toString()
                val detail = etDetail.text.toString()
                if (note == null) {
                    val newNote = Note(
                        nid = null,
                        title = title,
                        detail = detail,
                        date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                    )
                    insertNote(newNote)
                } else {
                    val updatedNote = note.copy(title = title, detail = detail)
                    updateNoteInDb(updatedNote)
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
            .show()
    }

    // note insert
    private fun insertNote(note: Note) {
        GlobalScope.launch(Dispatchers.IO) {
            db.NotesDao().insert(note)
            loadAllNotes()
        }
    }
    // note update
    private fun updateNoteInDb(note: Note) {
        GlobalScope.launch(Dispatchers.IO) {
            db.NotesDao().update(note)
            loadAllNotes()
        }
    }
    // note delete
    private fun deleteNote(note: Note) {
        GlobalScope.launch(Dispatchers.IO) {
            db.NotesDao().delete(note)
            loadAllNotes()
        }
    }
}