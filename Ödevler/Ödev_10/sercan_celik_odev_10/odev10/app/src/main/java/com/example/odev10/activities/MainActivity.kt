package com.example.odev10.activities

import android.content.Intent
import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.odev10.R
import com.example.odev10.adapters.NotesAdapter
import com.example.odev10.databinding.ActivityMainBinding
import com.example.odev10.models.Note
import com.example.odev10.services.NoteService
import com.example.odev10.services.UserService
import com.google.android.material.snackbar.Snackbar
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var noteService: NoteService
    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userService = UserService(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noteService = NoteService(this)
        val noteList: MutableList<Note> = noteService.getAllNotes().toMutableList()
        noteList.sortByDescending { it.nid }
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        notesAdapter = NotesAdapter(noteList)
        recyclerView.adapter = notesAdapter

        notesAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("note", it)
            startActivity(intent)
        }

        val itemTouchHelperCallback =
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    val note = notesAdapter.notes[position]

                    when (direction) {
                        ItemTouchHelper.LEFT -> {
                            noteService.deleteNote(note.nid)
                            removeAt(position)
                            checkEmptyState()

                            val snackbar = Snackbar.make(
                                binding.root,
                                getString(R.string.note_deleted),
                                Snackbar.LENGTH_LONG
                            )
                            snackbar.setAction(getString(R.string.undo)) {
                                noteService.addNote(note.title, note.content)
                                addAt(position, note)
                                checkEmptyState()
                            }
                            snackbar.setActionTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity,
                                    R.color.white
                                )
                            )
                            snackbar.anchorView = findViewById(R.id.floatingActionButton)
                            snackbar.show()
                        }

                        ItemTouchHelper.RIGHT -> {
                            val intent = Intent(this@MainActivity, UpdateActivity::class.java)
                            intent.putExtra("note", note)
                            startActivity(intent)
                            notesAdapter.notifyItemChanged(viewHolder.adapterPosition)
                        }
                    }
                }

                override fun onChildDraw(
                    c: Canvas,
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    dX: Float,
                    dY: Float,
                    actionState: Int,
                    isCurrentlyActive: Boolean
                ) {
                    RecyclerViewSwipeDecorator.Builder(
                        c,
                        recyclerView,
                        viewHolder,
                        dX,
                        dY,
                        actionState,
                        isCurrentlyActive
                    )
                        .addSwipeLeftBackgroundColor(
                            ContextCompat.getColor(this@MainActivity, R.color.red)
                        )
                        .addSwipeLeftActionIcon(R.drawable.ic_delete)
                        .addSwipeLeftLabel("Delete")
                        .setSwipeLeftLabelColor(
                            ContextCompat.getColor(this@MainActivity, R.color.white)
                        )
                        .addSwipeRightBackgroundColor(
                            ContextCompat.getColor(this@MainActivity, R.color.blue)
                        )
                        .addSwipeRightActionIcon(R.drawable.ic_edit)
                        .addSwipeRightLabel("Edit")
                        .setSwipeRightLabelColor(
                            ContextCompat.getColor(this@MainActivity, R.color.white)
                        )
                        .create()
                        .decorate()

                    super.onChildDraw(
                        c,
                        recyclerView,
                        viewHolder,
                        dX,
                        dY,
                        actionState,
                        isCurrentlyActive
                    )
                }
            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    val filteredNotes = noteService.searchNote(newText)
                    updateList(filteredNotes)
                }
                return false
            }
        })
    }

    override fun onResume() {
        super.onResume()
        sortByIdDescending()
        refreshNoteList()
    }

    private fun refreshNoteList() {
        updateList(noteService.getAllNotes())
        sortByIdDescending()
        notesAdapter.notifyDataSetChanged()
        checkEmptyState()
    }

    private fun checkEmptyState() {
        if (notesAdapter.itemCount == 0) {
            binding.recyclerView.visibility = View.GONE
            binding.tvEmptyMessage.visibility = View.VISIBLE
        } else {
            binding.recyclerView.visibility = View.VISIBLE
            binding.tvEmptyMessage.visibility = View.GONE
        }
    }

    private fun removeAt(position: Int) {
        notesAdapter.notes.removeAt(position)
        notesAdapter.notifyItemRemoved(position)
    }

    private fun addAt(position: Int, note: Note) {
        notesAdapter.notes.add(position, note)
        notesAdapter.notifyItemInserted(position)
    }

    private fun updateList(newNotes: List<Note>) {
        notesAdapter.notes.clear()
        notesAdapter.notes.addAll(newNotes)
        notesAdapter.notifyDataSetChanged()
    }

    private fun sortByIdDescending() {
        notesAdapter.notes.sortByDescending { it.nid }
        notesAdapter.notifyDataSetChanged()
    }
}
