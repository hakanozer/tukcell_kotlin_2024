package com.toren.odev10.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.toren.odev10.R
import com.toren.odev10.databinding.FragmentRegisterBinding
import com.toren.odev10.domain.model.User
import com.toren.odev10.presentation.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeRegister()

        binding.loginTxt.setOnClickListener {
            actionToLogin()
        }

        binding.registerBtn.setOnClickListener {
            val username = binding.registerUsernameEditTxt.text.toString().trim()
            val password = binding.registerPasswordEditTxt.text.toString().trim()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val user = User(0, username, password)
                viewModel.register(user)
                actionToNotes()
            }
        }
    }

    private fun observeRegister() {
        viewModel.registerResult.observe(viewLifecycleOwner) {
            it?.let {
                if (it) {
                    actionToNotes()
                } else if (!it) {
                    Toast.makeText(context, "Kullanıcı adı zaten var!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun actionToLogin() {
        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    private fun actionToNotes() {
        val action = RegisterFragmentDirections.actionRegisterFragmentToNotesFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}