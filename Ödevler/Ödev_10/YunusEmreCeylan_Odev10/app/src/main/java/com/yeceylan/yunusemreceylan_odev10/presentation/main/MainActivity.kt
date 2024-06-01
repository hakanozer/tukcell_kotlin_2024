package com.yeceylan.yunusemreceylan_odev10.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.yeceylan.yunusemreceylan_odev10.R
import com.yeceylan.yunusemreceylan_odev10.databinding.ActivityMainBinding
import com.yeceylan.yunusemreceylan_odev10.databinding.DialogAddNoteBinding
import com.yeceylan.yunusemreceylan_odev10.model.entity.Note
import com.yeceylan.yunusemreceylan_odev10.presentation.detail.DetailActivity
import com.yeceylan.yunusemreceylan_odev10.presentation.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val noteViewModel: NoteViewModel by viewModels()
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        username = intent.getStringExtra("username")

        val adapter = NoteAdapter(emptyList(), onEdit = { note -> openDetailActivity(note) }, onDelete = { note -> noteViewModel.delete(note) })
        binding.rvNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.rvNotes.adapter = adapter

        username?.let { noteViewModel.loadNotes(it) }

        noteViewModel.notes.observe(this) { notes ->
            adapter.updateNotes(notes)
        }

        binding.etSearch.addTextChangedListener {
            val query = it.toString()
            username?.let { username -> noteViewModel.searchNotes(username, query) }
        }

        binding.btnAddNote.setOnClickListener {
            showAddNoteDialog()
        }
    }

    private fun openDetailActivity(note: Note) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("note_id", note.id)
        intent.putExtra("note_title", note.title)
        intent.putExtra("note_content", note.content)
        intent.putExtra("username", note.username)
        startActivity(intent)
    }

    private fun showAddNoteDialog() {
        val dialogBinding = DialogAddNoteBinding.inflate(LayoutInflater.from(this))
        val dialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.add_note))
            .setView(dialogBinding.root)
            .setPositiveButton(getString(R.string.add), null)
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val title = dialogBinding.etNoteTitle.text.toString()
                val content = dialogBinding.etNoteContent.text.toString()
                var isValid = true

                if (title.isBlank()) {
                    dialogBinding.etNoteTitle.error = getString(R.string.title_is_required)
                    isValid = false
                } else {
                    dialogBinding.etNoteTitle.error = null
                }

                if (content.isBlank()) {
                    dialogBinding.etNoteContent.error = getString(R.string.content_is_required)
                    isValid = false
                } else {
                    dialogBinding.etNoteContent.error = null
                }

                if (isValid) {
                    val note = Note(title = title, content = content, username = username!!)
                    noteViewModel.insert(note)
                    dialog.dismiss()
                }
            }
        }

        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        username?.let { noteViewModel.loadNotes(it) }
    }
}
