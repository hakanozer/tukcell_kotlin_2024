package com.omersungur.omer_sungur_odev_10.presentation.note_detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.omersungur.omer_sungur_odev_10.R
import com.omersungur.omer_sungur_odev_10.core.viewBinding
import com.omersungur.omer_sungur_odev_10.databinding.FragmentNoteDetailBinding
import com.omersungur.omer_sungur_odev_10.domain.model.Note
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteDetailFragment : Fragment(R.layout.fragment_note_detail) {

    private val binding by viewBinding(FragmentNoteDetailBinding::bind)
    private val viewModel: NoteDetailViewModel by viewModels()
    private val bundle: NoteDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteId = bundle.noteArg.id

        lifecycleScope.launch {
            viewModel.getNoteById(noteId).collect { note ->
                binding.etNoteTitle.setText(note.title)
                binding.etNoteContent.setText(note.description)
            }
        }

        buttonEditOnClick()
    }


    private fun buttonEditOnClick() {
        binding.fabSave.setOnClickListener {

            val note = getEntry()

            if (!isEntryValid()) {
                Toast.makeText(requireContext(), "Alanları Boş Bırakmayın!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                updateNote(note.id, note.title, note.description)

                Navigation.findNavController(it)
                    .navigate(R.id.action_noteDetailFragment_to_noteListFragment)
            }
        }
    }

    private fun getEntry(): Note {
        val noteId = bundle.noteArg.id

        val noteTitle = binding.etNoteTitle.text.toString()
        val noteContent = binding.etNoteContent.text.toString()

        return Note(noteId, noteTitle, noteContent)
    }

    private fun updateNote(
        noteId: Int,
        noteTitle: String,
        noteContent: String,
    ) {
        viewModel.updateNote(
            noteId,
            noteTitle,
            noteContent,
        )
    }

    private fun isEntryValid(): Boolean {
        val noteTitle = binding.etNoteTitle.text.toString()
        val noteContent = binding.etNoteContent.text.toString()
        return viewModel.isEntryValid(noteTitle, noteContent)
    }
}