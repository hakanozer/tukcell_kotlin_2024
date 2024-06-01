package com.omersungur.omer_sungur_odev_10.presentation.note_list

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.omersungur.omer_sungur_odev_10.R
import com.omersungur.omer_sungur_odev_10.core.viewBinding
import com.omersungur.omer_sungur_odev_10.databinding.FragmentNoteListBinding
import com.omersungur.omer_sungur_odev_10.domain.model.Note
import com.omersungur.omer_sungur_odev_10.domain.repository.util.RoomOperation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListFragment : Fragment(R.layout.fragment_note_list), RoomOperation {

    private val binding by viewBinding(FragmentNoteListBinding::bind)
    private val viewModel: NoteListViewModel by viewModels()
    private lateinit var noteLisAdapter: NoteListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddItem.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_noteListFragment_to_addNoteFragment)
        }

        viewModel.noteList.observe(viewLifecycleOwner) {
            noteLisAdapter = NoteListAdapter(it, this@NoteListFragment)
            binding.rvNoteList.layoutManager = LinearLayoutManager(requireContext())
            binding.rvNoteList.adapter = noteLisAdapter
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchNote(newText)
                return false
            }
        })
    }

    override fun deleteNote(note: Note) {
        viewModel.deleteNote(note)
    }

    fun searchNote(query: String) {
        viewModel.searchNote(query)
    }
}