package com.example.odev10

import android.app.AlertDialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.odev10.adapter.NoteAdapter
import com.example.odev10.config.AppDatabase
import com.example.odev10.databinding.ActivityNoteBinding
import com.example.odev10.entitie.Note
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var binding: ActivityNoteBinding
    private val scope = CoroutineScope(Dispatchers.Main)
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "user_database"
        ).build()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = NoteAdapter(emptyList(),
            onDeleteClick = { note -> deleteNote(note) },
            onEditClick = { note -> editNoteDialog(note) }
        )
        binding.recyclerView.adapter = adapter

        loadNotes()

        binding.btnSave.setOnClickListener {
            saveNote()
        }

        binding.btnSearch.setOnClickListener {
            val query = binding.etSearch.text.toString()
            adapter.searchNotes(query)
        }
    }

    private fun loadNotes() {
        scope.launch {
            val notes = withContext(Dispatchers.IO) {
                db.noteDao().getAllNotes()
            }
            adapter.updateNotes(notes)
        }
    }

    private fun saveNote() {
        val title = findViewById<EditText>(R.id.txtTitle).text.toString()
        val content = findViewById<EditText>(R.id.txtContent).text.toString()

        if (title.isNotEmpty() && content.isNotEmpty()) {
            scope.launch(Dispatchers.IO) {
                val note = Note(
                    title = title,
                    content = content
                )
                db.noteDao().insert(note)
                withContext(Dispatchers.Main) {
                    loadNotes()
                    binding.txtTitle.text.clear()
                    binding.txtContent.text.clear()
                }
            }
        } else {
        }
    }

    private fun deleteNote(note: Note) {
        scope.launch(Dispatchers.IO) {
            db.noteDao().delete(note)
            withContext(Dispatchers.Main) {
                loadNotes()
            }
        }
    }
    private fun editNoteDialog(note: Note) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_edit_note, null)
        val dialogTitle = dialogView.findViewById<EditText>(R.id.dialogTitle)
        val dialogCont = dialogView.findViewById<EditText>(R.id.dialogContent)

        dialogTitle.setText(note.title)
        dialogCont.setText(note.content)

        AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Save") { _, _ ->
                val editedTitle = dialogTitle.text.toString()
                val editedContent = dialogCont.text.toString()

                if (editedTitle.isNotEmpty() && editedContent.isNotEmpty()) {
                    editNote(note, editedTitle, editedContent)
                } else {
                    Snackbar.make(binding.root, "Please fill in all fields", Snackbar.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun editNote(note: Note, editedTitle: String, editedContent: String) {
        scope.launch(Dispatchers.IO) {
            val editedNote = note.copy(title = editedTitle, content = editedContent)
            db.noteDao().update(editedNote)
            withContext(Dispatchers.Main) {
                loadNotes()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}