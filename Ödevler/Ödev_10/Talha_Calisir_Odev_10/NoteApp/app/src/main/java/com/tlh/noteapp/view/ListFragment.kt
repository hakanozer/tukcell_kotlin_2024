package com.tlh.noteapp.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.tlh.noteapp.Adapter.NoteAdapter
import com.tlh.noteapp.R
import com.tlh.noteapp.databinding.FragmentListBinding
import com.tlh.noteapp.model.Note
import com.tlh.noteapp.room.NoteDao
import com.tlh.noteapp.room.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var dao: NoteDao
    private lateinit var db: NoteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            initializeDatabase()
        }
    }

    private suspend fun initializeDatabase() {
        withContext(Dispatchers.IO) {
            db = Room.databaseBuilder(requireContext(), NoteDatabase::class.java, "NotesList").build()
            dao = db.noteDao()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        binding.imageButton4.setOnClickListener { clickable(it) }
        binding.floatingActionButton.setOnClickListener { addNote() }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getDatas()
    }

    private fun clickable(view: View) {
        val popupMenu = PopupMenu(requireContext(), binding.imageButton4)
        popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.logout -> logOut()
                R.id.exit -> exitApp()
                else -> false
            }
        }
        popupMenu.show() // Ensure the popup menu is shown
    }

    private fun getDatas() {
        lifecycleScope.launch {
            val notes = withContext(Dispatchers.IO) {
                dao.getAll()
            }
            handleResponse(notes)
        }
    }

    private fun handleResponse(list: List<Note>) {
        val noteAdapter = NoteAdapter(list)
        binding.recyclerView.adapter = noteAdapter
    }

    private fun logOut(): Boolean {
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }
        val action = ListFragmentDirections.actionListFragmentToLoginFragment()
        findNavController().navigate(action)
        return true
    }

    private fun addNote() {
        val action = ListFragmentDirections.actionListFragmentToNoteFragment()
        findNavController().navigate(action)
    }

    private fun exitApp(): Boolean {
        requireActivity().finish()
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
