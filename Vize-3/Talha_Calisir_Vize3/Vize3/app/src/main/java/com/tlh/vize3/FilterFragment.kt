package com.tlh.vize3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tlh.vize3.databinding.FragmentFilterBinding
import com.tlh.vize3.ui.UserViewModel

class FilterFragment : Fragment() {
    private lateinit var _binding: FragmentFilterBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.applyButton.setOnClickListener {
            val key = when {
                binding.radioFirstName.isChecked -> "firstName"
                binding.radioLastName.isChecked -> "lastName"
                binding.radioAge.isChecked -> "age"
                binding.radioBloodGroup.isChecked -> "bloodGroup"
                else -> return@setOnClickListener
            }
            val value = binding.editTextValue.text.toString()

            // Get the MainViewModel and apply the filter
            val viewModel: UserViewModel = (activity as MainActivity).viewModel
            viewModel.fetchFilteredUsers(key, value)

            // Navigate back to MainFragment
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}