package com.toren.odev10.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.toren.odev10.R
import com.toren.odev10.common.UserSession
import com.toren.odev10.databinding.FragmentAddNoteBinding
import com.toren.odev10.domain.model.Note
import com.toren.odev10.presentation.viewmodel.AddNoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            addNoteSaveBtn.setOnClickListener {
                val title = addNoteTitleTxt.text.toString()
                val content = addNoteTxt.text.toString()
                if (title.isNotEmpty() && content.isNotEmpty()) {
                    val note = Note(0, title, content, UserSession.USER_ID!!)
                    viewModel.addNote(note)
                    observeAddNoteResult()
                }
            }
        }

    }

    private fun observeAddNoteResult() {
        viewModel.noteResult.observe(viewLifecycleOwner) {
            it?.let {
                if (it) {
                    actionToNotes()
                } else if (!it) {
                    Log.e("AddNoteFragment", "Error")
                }
            }
        }
    }

    private fun actionToNotes() {
        val action = AddNoteFragmentDirections.actionAddNoteFragmentToNotesFragment()
        findNavController().navigate(action)
    }


}