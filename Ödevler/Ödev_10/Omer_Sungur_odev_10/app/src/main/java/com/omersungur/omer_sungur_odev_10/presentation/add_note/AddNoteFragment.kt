package com.omersungur.omer_sungur_odev_10.presentation.add_note

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.omersungur.omer_sungur_odev_10.R
import com.omersungur.omer_sungur_odev_10.core.viewBinding
import com.omersungur.omer_sungur_odev_10.databinding.FragmentAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment(R.layout.fragment_add_note) {

    private val binding by viewBinding(FragmentAddNoteBinding::bind)
    private val viewModel: AddNoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabSave.setOnClickListener {
            insertNote(binding.etNoteTitle.text.toString(), binding.etNoteContent.text.toString())
        }
    }

    private fun insertNote(noteTitle: String, noteContent: String) {
        viewModel.insertNote(noteTitle, noteContent)
    }
}