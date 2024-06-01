package com.ns.enesarisoy_odev11

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ns.enesarisoy_odev11.configs.NoteOperations
import com.ns.enesarisoy_odev11.databinding.ActivityMainBinding
import com.ns.enesarisoy_odev11.model.Note
import com.ns.enesarisoy_odev11.presentation.CreateActivity
import com.ns.enesarisoy_odev11.presentation.LoginActivity
import com.ns.enesarisoy_odev11.presentation.adapter.NoteAdapter
import com.ns.enesarisoy_odev11.util.hideKeyboard

class MainActivity : AppCompatActivity(), NoteAdapter.OnNoteClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteOperations: NoteOperations
    private lateinit var noteAdapter: NoteAdapter
    private var userId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteOperations = NoteOperations(this)
        noteAdapter = NoteAdapter(mutableListOf(), this)

        userId = intent.getIntExtra("USER_ID", -1)
        if (userId == -1) {
            finish()
            return
        }
        with(binding) {

            recyclerView.layoutManager =
                StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            recyclerView.adapter = noteAdapter

            etSearch.addTextChangedListener {
                if (it.isNullOrEmpty()) {
                    tlSearch.startIconDrawable = ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_search,
                        null
                    )
                } else {
                    tlSearch.startIconDrawable = ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.baseline_close_24,
                        null
                    )
                    tlSearch.setStartIconOnClickListener {
                        etSearch.text?.clear()
                        etSearch.clearFocus()
                        it.hideKeyboard()
                    }
                }
                searchNotes(it.toString())
            }
            fabCreate.setOnClickListener {
                val intent = Intent(this@MainActivity, CreateActivity::class.java)
                intent.putExtra("USER_ID", userId)
                startActivity(intent)
            }
        }

        loadNotes()

    }

    private fun loadNotes() {
        val notes = noteOperations.getAllNotes(userId)
        noteAdapter.updateNotes(notes)
    }

    private fun searchNotes(query: String) {
        val notes = noteOperations.searchNotes(userId, query)
        noteAdapter.updateNotes(notes)
    }

    override fun onNoteClick(note: Note) {
        val intent = Intent(this, CreateActivity::class.java)
        intent.putExtra("NOTE_ID", note.id)
        intent.putExtra("USER_ID", userId)
        startActivity(intent)
    }

    override fun onNoteLongClick(note: Note) {
        noteOperations.deleteNote(userId, note.id)
        Toast.makeText(this, "Not silindi", Toast.LENGTH_SHORT).show()
        loadNotes()
    }
}