package com.bengisusahin.odev_10.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bengisusahin.odev_10.R
import com.bengisusahin.odev_10.adapter.NoteAdapter
import com.bengisusahin.odev_10.databinding.ActivityMainBinding
import com.bengisusahin.odev_10.models.Note
import com.bengisusahin.odev_10.services.NoteService
import com.bengisusahin.odev_10.utils.SwipeToDelete

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteService: NoteService
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var allNotes:MutableList<Note>
    private var userId: Int = -1

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

        noteService = NoteService(this)
        userId = intent.getIntExtra("userId", -1)

        setUpFloatingActionButton()
        setUpRecyclerView()
        setUpSearchView()
        setUpMenu()

        swipeToDelete(binding.recyclerView)
    }

    // runs after onPause when the user returns to the activity
    override fun onResume() {
        super.onResume()
        // Update the notes list and refresh the RecyclerView after updating the notes
        allNotes.clear()
        allNotes.addAll(noteService.getNotesForUser(userId))
        noteAdapter.notifyDataSetChanged()
    }

    // Set up the floating action button to navigate to the AddNoteActivity
    private fun setUpFloatingActionButton() {
        binding.floatingActionAddNoteButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            intent.putExtra("userId", userId)
            startActivity(intent)
        }
    }

    // Set up the RecyclerView with the notes list
    private fun setUpRecyclerView() {
        allNotes = noteService.getNotesForUser(userId)
        Log.d("allNotes",allNotes.toString())
        noteAdapter = NoteAdapter(allNotes)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = noteAdapter

        noteAdapter.onNoteClick = { note ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("noteId", note.nid)
            startActivity(intent)
        }
    }

    // Set up the SearchView to search notes by title or content
    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                performSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                performSearch(newText)
                return true
            }
        })
    }
    private fun performSearch(query: String?) {
        val trimmedQuery = query?.trim()
        if (trimmedQuery.isNullOrEmpty()) {
            // If the query is empty after trimming, do nothing and return the current list
            noteAdapter.updateNotes(allNotes)
        } else {
            val filteredNotes = noteService.searchNotes(trimmedQuery, userId)
            noteAdapter.updateNotes(filteredNotes)
        }
    }

    // Set up the menu button to show the popup menu with delete all notes and logout options
    private fun setUpMenu() {
        binding.menuButton.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.deleteAll -> {
                        AlertDialog.Builder(this)
                            .setTitle("Delete All Note")
                            .setMessage("Are you sure you want to delete all note?")
                            .setPositiveButton("Yes") { _, _ ->
                                noteService.deleteAllNotesForUser(userId)
                                allNotes.clear()
                                noteAdapter.notifyDataSetChanged()
                                Toast.makeText(this, "Notes deleted", Toast.LENGTH_SHORT).show()
                            }
                            .setNegativeButton("No", ){dialog, _ ->
                                dialog.dismiss()
                            }
                            .show()
                        true
                    }R.id.logout -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }

                    else -> false
                }
            }
            popupMenu.show()
        }
    }

    // Swipe to delete feature for RecyclerView items
    private fun swipeToDelete(recyclerView: RecyclerView) {
        val swipeHandler = object : SwipeToDelete() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val note = allNotes[position]

                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Delete Note")
                    .setMessage("Are you sure you want to delete this note?")
                    .setPositiveButton("Yes") { _, _ ->
                        noteService.deleteNoteById(note.nid)
                        allNotes.removeAt(position)
                        noteAdapter.notifyItemRemoved(position)
                        Toast.makeText(this@MainActivity, "Note deleted", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No",){ dialog, _ ->
                        dialog.dismiss()
                        noteAdapter.notifyItemChanged(position)
                    }
                    .show()
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}