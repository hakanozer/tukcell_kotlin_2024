package com.omersungur.omer_sungur_odev_10.presentation.authentication.log_in

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.omersungur.omer_sungur_odev_10.R
import com.omersungur.omer_sungur_odev_10.core.customToast
import com.omersungur.omer_sungur_odev_10.core.viewBinding
import com.omersungur.omer_sungur_odev_10.databinding.FragmentLoginBinding
import com.omersungur.omer_sungur_odev_10.presentation.authentication.AuthenticationViewModel
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: AuthenticationViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogIn.setOnClickListener {
            logIn()
        }
    }

    private fun logIn() {
        with(binding) {
            val email = userEmail.editText?.text.toString()
            val password = userPassword.editText?.text.toString()

            val users = viewModel.getUsers()

            lifecycleScope.launch {
                users.collect { userList ->
                    val checkUserInfo = userList.find {
                        it.email == email && it.password == password
                    }

                    if (checkUserInfo != null) {
                        navigateToNoteList()
                    } else {
                        requireContext().customToast("Kullanıcı adı veya şifre yanlış")
                    }
                }
            }
        }
    }

    private fun navigateToNoteList() {
        val navigate = LoginFragmentDirections.actionLoginFragmentToNoteListFragment()
        Navigation.findNavController(requireView()).navigate(navigate)
    }
}