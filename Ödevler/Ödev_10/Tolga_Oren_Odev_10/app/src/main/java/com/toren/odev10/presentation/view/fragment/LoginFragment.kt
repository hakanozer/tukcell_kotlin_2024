package com.toren.odev10.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.navigation.fragment.findNavController
import com.toren.odev10.databinding.FragmentLoginBinding
import com.toren.odev10.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeAuthentication()

        binding.loginBtn.setOnClickListener {
            val username = binding.loginUsernameEditTxt.text.toString().trim()
            val password = binding.loginPasswordEditTxt.text.toString().trim()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                viewModel.authenticationUser(username, password)
            }
        }

        binding.signUpTxt.setOnClickListener {
            actionToRegister()
        }

    }

    private fun observeAuthentication() {
        viewModel.loginResult.observe(viewLifecycleOwner) {
            it?.let {
                if (it) {
                    actionToNotes()
                } else if (!it) {
                    Toast.makeText(context, "Giriş Başarısız", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun actionToNotes() {
        println("actionToNotes")
        val action = LoginFragmentDirections.actionLoginFragmentToNotesFragment()
        findNavController().navigate(action)
    }

    private fun actionToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}