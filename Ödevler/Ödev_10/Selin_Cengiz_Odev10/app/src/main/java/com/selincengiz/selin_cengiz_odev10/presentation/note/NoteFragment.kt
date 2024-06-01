package com.selincengiz.selin_cengiz_odev10.presentation.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.selincengiz.selin_cengiz_odev10.R
import com.selincengiz.selin_cengiz_odev10.databinding.FragmentNoteBinding
import com.selincengiz.selin_cengiz_odev10.domain.entities.NotesUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding
    private val viewModel by viewModels<NoteViewModel>()
    private val args by navArgs<NoteFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note, container, false)
        binding.noteFunctions = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.note?.let {
            Toast.makeText(requireContext(), it.id.toString(), Toast.LENGTH_SHORT).show()
            binding.etBody.setText(it.body)
            binding.etTitle.setText(it.title)
        }
    }

    fun backClicked() {
        findNavController().navigateUp()
    }

    fun deleteClicked() {
        args.note?.let {
            viewModel.delete(it)
        }
        findNavController().navigateUp()
    }

    fun checkClicked() {
        val body = binding.etBody.text.toString()
        val title = binding.etTitle.text.toString()

        if (body.isEmpty().not() && title.isEmpty().not()) {
            val note = NotesUI(id = args.note?.id ?: 0, title = title, body = body)
            viewModel.upsert(note)
            findNavController().navigateUp()
        }
    }
}