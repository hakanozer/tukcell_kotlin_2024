package com.canerdedeoglu.odev10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.canerdedeoglu.odev10.adapter.NoteAdapter
import com.canerdedeoglu.odev10.models.Notes
import com.canerdedeoglu.odev10.services.NoteService


class HomeActivity : AppCompatActivity() {

    private lateinit var noteListView : ListView
    private lateinit var ic_plus : ImageView
    private lateinit var txt_Search: EditText
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var noteList: ArrayList<Notes>
    private lateinit var filteredNoteList: ArrayList<Notes>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        noteListView = findViewById(R.id.note_listview)
        ic_plus = findViewById(R.id.ic_plus)
        txt_Search = findViewById(R.id.txt_Search)
        ic_plus.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        loadNote()

        noteListView.setOnItemClickListener { parent, view, position, id ->

            val selectedNote = noteList[position]
            val intent = Intent(this, EditNoteActivity::class.java)
            intent.putExtra("noteId", selectedNote.noteId)
            intent.putExtra("noteTitle", selectedNote.title)
            intent.putExtra("noteDescription", selectedNote.description)
            intent.putExtra("noteDate", selectedNote.date)
            intent.putExtra("noteCategory",selectedNote.category)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        loadNote()  // Listeyi her seferinde yeniden yükle

        txt_Search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterNotes(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed before text changes
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No action needed during text changes
            }
        })
    }

    private fun loadNote() {
        val userId = getUserId()
        val noteService = NoteService(this)
        noteList = noteService.getAllNotes(userId) as ArrayList<Notes>
        filteredNoteList = ArrayList(noteList)

        Log.d("HomeActivity", "Loaded notes: ${noteList.size}")

        // Adapter mevcutsa güncelle
        if (::noteAdapter.isInitialized) {
            noteAdapter.clear()
            noteAdapter.addAll(filteredNoteList)
            noteAdapter.notifyDataSetChanged()
        } else {
            // Adapter yoksa yeni oluştur
            noteAdapter = NoteAdapter(this, filteredNoteList)
            noteListView.adapter = noteAdapter
        }
    }

    private fun filterNotes(query: String) {
        val noteService = NoteService(this)
        if (query.isEmpty()) {
            // Metin boşsa tüm notları yükle
            loadNote()
        } else {
            // Metin doluysa filtreleme yap
            filteredNoteList = noteService.getNotesByCategoryAndTitle(query) as ArrayList<Notes>
            if (::noteAdapter.isInitialized) {
                noteAdapter.clear()
                noteAdapter.addAll(filteredNoteList)
                noteAdapter.notifyDataSetChanged()
            }
        }
    }


    private fun getUserId(): Int {
        val sharedPreferences = this.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getInt("USER_ID", -1)
        if (userId == -1) {
            Log.e("HomeActivity", "User ID not found")
        }
        return userId
    }
}