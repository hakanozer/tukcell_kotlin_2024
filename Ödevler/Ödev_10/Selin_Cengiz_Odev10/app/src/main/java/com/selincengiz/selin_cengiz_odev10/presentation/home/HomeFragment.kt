package com.selincengiz.selin_cengiz_odev10.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.selincengiz.selin_cengiz_odev10.R
import com.selincengiz.selin_cengiz_odev10.common.HomeState
import com.selincengiz.selin_cengiz_odev10.databinding.FragmentHomeBinding
import com.selincengiz.selin_cengiz_odev10.domain.entities.NotesUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), ItemListener, SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomeBinding
    private val adapter by lazy { NoteAdapter(this) }
    private val viewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.homeFunctions = this
        binding.listView.adapter = adapter
        binding.searchView.setOnQueryTextListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNotes()
        observe()
    }

    private fun observe() {
        lifecycleScope.launch {
            viewModel.homeState.collectLatest { state ->
                when (state) {
                    is HomeState.Notes -> {
                        adapter.submitList(state.list)
                    }

                    is HomeState.Error -> {
                        Toast.makeText(
                            requireContext(),
                            state.throwable.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {}
                }
            }
        }
    }

    fun addClicked() {
        findNavController().navigate(HomeFragmentDirections.homeToNote(null))
    }

    override fun onClicked(note: NotesUI) {
        findNavController().navigate(HomeFragmentDirections.homeToNote(note))

    }

    override fun onQueryTextSubmit(text: String?): Boolean {
        text?.let {
            viewModel.getNotesByQuery(it)
        }
        return true
    }

    override fun onQueryTextChange(text: String?): Boolean {
        text?.let {
            if (it.length > 3) {
                viewModel.getNotesByQuery(it)
            } else {
                viewModel.getNotes()
            }
        }
        return true
    }
}