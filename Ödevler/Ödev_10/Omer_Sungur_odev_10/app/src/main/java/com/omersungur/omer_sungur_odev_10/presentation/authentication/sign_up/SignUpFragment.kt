package com.omersungur.omer_sungur_odev_10.presentation.authentication.sign_up

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.omersungur.omer_sungur_odev_10.R
import com.omersungur.omer_sungur_odev_10.core.customToast
import com.omersungur.omer_sungur_odev_10.core.viewBinding
import com.omersungur.omer_sungur_odev_10.databinding.FragmentSignupBinding
import com.omersungur.omer_sungur_odev_10.domain.model.User
import com.omersungur.omer_sungur_odev_10.presentation.authentication.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_signup) {

    private val binding by viewBinding(FragmentSignupBinding::bind)
    private val viewModel: AuthenticationViewModel by activityViewModels()
    private var usersEmail: MutableList<String> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.userList.collect { users ->
                users.forEach {
                    usersEmail.add(it.email)
                }
            }
        }

        binding.btnSignUp.setOnClickListener {
            signUp()
        }

        binding.btnLogIn.setOnClickListener {
            val navigate = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
            Navigation.findNavController(requireView()).navigate(navigate)
        }
    }

    private fun signUp() {
        lifecycleScope.launch {
            with(binding) {
                val name = userName.editText?.text.toString()
                val email = userEmail.editText?.text.toString()
                val password = userPassword.editText?.text.toString()

                val checkIsNotEmpty = viewModel.checkUserInputForRegister(name, email, password)

                if (checkIsNotEmpty) {
                    if (viewModel.checkEmailIsAvailable(usersEmail, email)) {
                        val registerUser = User(0, name, email, password)

                        viewModel.insertUser(registerUser)
                        navigateToNoteList()
                        requireContext().customToast("Sign up successful")
                    } else {
                        requireContext().customToast("Email already exists")
                    }

                } else {
                    requireContext().customToast("Lütfen tüm alanları doldurun")
                }
            }
        }
    }

    private fun navigateToNoteList() {
        val navigate = SignUpFragmentDirections.actionSignUpFragmentToNoteListFragment()
        Navigation.findNavController(requireView()).navigate(navigate)
    }
}