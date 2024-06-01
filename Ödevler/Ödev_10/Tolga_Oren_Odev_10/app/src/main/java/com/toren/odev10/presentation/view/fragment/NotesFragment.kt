package com.toren.odev10.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.toren.odev10.R
import com.toren.odev10.databinding.FragmentNotesBinding
import com.toren.odev10.domain.model.Note
import com.toren.odev10.presentation.view.adapter.NoteAdapter
import com.toren.odev10.presentation.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment(),
    NoteAdapter.OnItemClickListener {

    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NotesViewModel by viewModels()
    private val noteAdapter = NoteAdapter(mutableListOf(),this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.notesToolbar.inflateMenu(R.menu.search_item)
        val searchItem = binding.notesToolbar.menu.findItem(R.id.search_action)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.filterNotes(query.orEmpty())
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                viewModel.filterNotes(text.orEmpty())
                return true
            }

        })

        binding.notesRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.notesRecyclerView.adapter = noteAdapter
        observeNotes()
        observeFilteredNotes()
        binding.addNoteFab.setOnClickListener {
            actionToAddNote()
        }
    }

    private fun observeNotes() {
        viewModel.notes.observe(viewLifecycleOwner) {
            it?.let {
                noteAdapter.updateNotes(it)
            }
        }
    }

    private fun observeFilteredNotes() {
        viewModel.filteredNotes.observe(viewLifecycleOwner) {
            it?.let {
                noteAdapter.updateNotes(it)
            }
        }
    }

    private fun actionToAddNote() {
        val action = NotesFragmentDirections.actionNotesFragmentToAddNoteFragment()
        findNavController().navigate(action)
    }

    private fun actionToNote(note: Note) {
        val action = NotesFragmentDirections.actionNotesFragmentToNoteDetailFragment(note)
        findNavController().navigate(action)
    }

    override fun onItemClick(position: Note) {
        actionToNote(position)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}