package com.toren.odev10.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.toren.odev10.R
import com.toren.odev10.databinding.FragmentNoteDetailBinding
import com.toren.odev10.domain.model.Note
import com.toren.odev10.presentation.viewmodel.NoteDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailFragment : Fragment() {

    private var _binding: FragmentNoteDetailBinding? = null
    private val binding get() = _binding!!
    private val args: NoteDetailFragmentArgs by navArgs()
    private val viewModel: NoteDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editNoteSaveBtn.setOnClickListener {
            handleNoteAction { note ->
                viewModel.editNote(note)
            }
            observeResponse()
        }

        binding.editNoteDeleteBtn.setOnClickListener {
            handleNoteAction { note ->
                viewModel.deleteNote(note)
            }
            observeResponse()
        }

        args.note.let {
            loadNote(it)
        }
    }

    private fun handleNoteAction(action: (Note) -> Unit) {
        val title = binding.editNoteTitleTxt.text.toString()
        val content = binding.editNoteTxt.text.toString()
        if (inputControl(title, content)) {
            val note = createNoteFromInputs(title, content)
            action(note)
        } else {
            Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputControl(title: String, note: String): Boolean {
        return title.isNotBlank() && note.isNotBlank()
    }

    private fun createNoteFromInputs(title: String, note: String): Note {
        return Note(
            id = args.note.id,
            title = title,
            note = note,
            userId = args.note.userId
        )
    }

    private fun observeResponse() {
        viewModel.editResult.observe(viewLifecycleOwner) {
            it?.let {
                if (it) {
                    actionToNote()
                }
            }
        }
    }

    private fun actionToNote() {
        val action = NoteDetailFragmentDirections.actionNoteDetailFragmentToNotesFragment()
        findNavController().navigate(action)
    }

    private fun loadNote(note: Note) {
        binding.apply {
            editNoteTitleTxt.setText(note.title)
            editNoteTxt.setText(note.note)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}