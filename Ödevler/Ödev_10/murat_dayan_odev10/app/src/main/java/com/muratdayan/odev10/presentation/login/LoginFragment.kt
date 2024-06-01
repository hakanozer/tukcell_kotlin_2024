package com.muratdayan.odev10.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.muratdayan.odev10.R
import com.muratdayan.odev10.common.components.CustomToast
import com.muratdayan.odev10.common.components.UserSharedPrefManager
import com.muratdayan.odev10.common.utils.showAlertDialog
import com.muratdayan.odev10.databinding.FragmentLoginBinding
import com.muratdayan.odev10.services.UserService


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var userSharedPrefManager: UserSharedPrefManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // animation
        val fadeAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.anim)
        binding.txtLogin.startAnimation(fadeAnim)


        val userService = UserService(requireContext())

        // fieldları kontrol eder ve kayıt varsa login yoksa register işlemi yapar
        binding.btnLogIn.setOnClickListener {
            val userName = binding.editTxtUserName.text.toString().trim()
            val password = binding.editTxtPassword.text.toString().trim()

            if (userName.isNotEmpty() && password.isNotEmpty()) {
                val isUserAvailability = userService.controlUserNameAvailability(userName)
                if (isUserAvailability) {
                    val user = userService.getUser(userName, password)
                    if (user != null) {
                        rememberUser(user.username)
                        findNavController().navigate(R.id.navigate_loginFragment_to_notesFragment)
                    } else {
                        CustomToast(requireActivity(), "Wrong Password", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    showAlertDialog(
                        "Sign Up",
                        "This username is not available.Do you want to sign up?",
                        onPositiveClick = {
                            val status = userService.addUser(userName, password)
                            if (status == 0.toLong()) {
                                CustomToast(
                                    requireActivity(),
                                    "Failed to Register",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                rememberUser(userName)
                                findNavController().navigate(R.id.navigate_loginFragment_to_notesFragment)
                            }
                        },
                        onNegativeClick = {
                            CustomToast(
                                requireActivity(),
                                "Failed to Register",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            } else {
                CustomToast(
                    requireActivity(),
                    "please fill in the blanks",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root

    }

    // Önceden kayıt olan kullanıcı bilgisini tutar
    fun rememberUser(username: String) {
        userSharedPrefManager = UserSharedPrefManager(requireContext())

        if (binding.checkBoxRememberMe.isChecked) {
            userSharedPrefManager.setUserName(username)
        } else {
            val registeredUsername = userSharedPrefManager.getUserName()
            registeredUsername?.let {
                userSharedPrefManager.deleteUser()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}