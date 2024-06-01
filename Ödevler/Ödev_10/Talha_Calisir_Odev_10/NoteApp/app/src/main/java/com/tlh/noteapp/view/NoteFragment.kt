package com.tlh.noteapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.tlh.noteapp.R
import com.tlh.noteapp.databinding.FragmentNoteBinding
import com.tlh.noteapp.model.Note
import com.tlh.noteapp.room.NoteDao
import com.tlh.noteapp.room.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: NoteDatabase
    private lateinit var dao: NoteDao
    private var chosenNote: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            initializeDatabase()
        }
    }

    private suspend fun initializeDatabase() {
        withContext(Dispatchers.IO) {
            db = Room.databaseBuilder(requireContext(), NoteDatabase::class.java, "NotesList")
                .build()
            dao = db.noteDao()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener { saveNote() }
        binding.deleteButton.setOnClickListener { deleteNote() }
    }

    private fun saveNote() {
        val noteTitle = binding.noteTitle.text.toString()
        val noteBody = binding.noteBody.text.toString()
        val note = Note(noteTitle, noteBody)
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                dao.insert(note)
            }
            withContext(Dispatchers.Main) {
                navigateToNoteList()
            }
        }
    }

    private fun navigateToNoteList() {
        val action = NoteFragmentDirections.actionNoteFragmentToListFragment()
        findNavController().navigate(action)
    }

    private fun deleteNote() {
        chosenNote?.let { note ->
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    dao.delete(note)
                }
                withContext(Dispatchers.Main) {
                    navigateToNoteList()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}