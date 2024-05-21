package com.tlh.vize3

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tlh.vize3.adapters.UserAdapter
import com.tlh.vize3.databinding.FragmentFilterBinding
import com.tlh.vize3.databinding.FragmentMainBinding
import com.tlh.vize3.ui.UserViewModel

class MainFragment : Fragment() {
    private lateinit var _binding: FragmentMainBinding
    private val binding get() = _binding!!
    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: created")
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        // Get the adapter from the MainActivity
        val adapter = (requireActivity() as MainActivity).adapter

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        // Observe the users LiveData object correctly
        viewModel.users.observe(viewLifecycleOwner) { users ->
            adapter.updateData(users)
        }

        binding.filterButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_filterFragment)
        }
    }

}