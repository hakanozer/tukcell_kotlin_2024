package com.emrecura.homework_10.presentation

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.LinearLayoutManager
import com.emrecura.homework_10.R
import com.emrecura.homework_10.adapters.NoteAdapter
import com.emrecura.homework_10.databinding.ActivityMainBinding
import com.emrecura.homework_10.model.NoteModel
import com.emrecura.homework_10.services.NoteService
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteService: NoteService
    private lateinit var adapter : NoteAdapter
    private var currentUserId : Int = -1
    private lateinit var noteList : List<NoteModel>
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sharedPreferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
        currentUserId = sharedPreferences.getInt("user_id", -1)



        noteService = NoteService(this)
        noteList = noteService.getNotesByUserId(currentUserId)// sadece güncel kullanıcın notlarını getirir
        val recyclerView = binding.noteRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter = NoteAdapter(noteList)
        recyclerView.adapter = adapter


        binding.addNote.setOnClickListener {
            showAddNoteDialog()
        }

        binding.searchButton.setOnClickListener {
            searchNote()
        }


    }

    private fun searchNote() {
        val query = binding.searchText.text.toString()
        val notes = noteService.searchNote(query)
        adapter.updateList(notes)
    }

    private fun showAddNoteDialog() {

        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_note, null)

        val titleEditText = dialogLayout.findViewById<EditText>(R.id.titleEditText)
        val detailEditText = dialogLayout.findViewById<EditText>(R.id.detailEditText)


        val dialog = AlertDialog.Builder(this)
            .setTitle("Add Note")
            .setView(dialogLayout)
            .setPositiveButton("Add") { dialog, _ ->
                val title = titleEditText.text.toString()
                val detail = detailEditText.text.toString()
                val date = getCurrentDate()

                noteService.addNote(currentUserId, title, detail, date)

                // yeni bir note eklediğimizde recycler view'de hemen gözükmesi için updateList fonksiyonunu kullanıyoruz
                val newNoteList = noteService.getNotesByUserId(currentUserId)
                adapter.updateList(newNoteList)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .create()

        dialog.show()
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(Date())
    }


}