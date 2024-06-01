package com.tlh.noteapp.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.tlh.noteapp.R
import com.tlh.noteapp.databinding.FragmentLoginBinding
import com.tlh.noteapp.model.User
import com.tlh.noteapp.room.UserDao
import com.tlh.noteapp.room.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var db: UserDatabase
    private lateinit var dao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        lifecycleScope.launch {
            initializeDatabase()
        }
    }

    private suspend fun initializeDatabase() {
        withContext(Dispatchers.IO) {
            db = Room.databaseBuilder(requireContext(), UserDatabase::class.java, "Notes").build()
            dao = db.userDao()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerbuttonToregister.setOnClickListener { moveToRegister() }

        val savedUsername = sharedPreferences.getString("username", null)
        val savedPassword = sharedPreferences.getString("password", null)

        if (savedUsername != null && savedPassword != null) {
            navigateToHomeFragment()
        } else {
            binding.loginButton.setOnClickListener { login() }
        }
    }

    private fun moveToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(action)
    }

    private fun login() {
        val username = binding.inputUsername.text.toString()
        val password = binding.inputPassword.text.toString()
        if (username.isNotEmpty() && password.isNotEmpty()) {
            lifecycleScope.launch {
                val user = withContext(Dispatchers.IO) {
                    dao.readUserByName(username)
                }
                withContext(Dispatchers.Main) {
                    if (user != null && user.userPassword == password) {
                        saveCredentials(username, password)
                        Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()
                        navigateToHomeFragment()
                    } else {
                        Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } else {
            Toast.makeText(requireContext(), "Username and Password cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveCredentials(username: String, password: String) {
        with(sharedPreferences.edit()) {
            putString("username", username)
            putString("password", password)
            apply()
        }
    }

    private fun navigateToHomeFragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToListFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}