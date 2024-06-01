package com.tlh.noteapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room

import com.tlh.noteapp.databinding.FragmentRegisterBinding
import com.tlh.noteapp.model.User
import com.tlh.noteapp.room.UserDao
import com.tlh.noteapp.room.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    lateinit var userdb: UserDatabase
    lateinit var userdao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the database in a background thread
        lifecycleScope.launch {
            initializeDatabase()
        }
    }

    private suspend fun initializeDatabase() {
        withContext(Dispatchers.IO) {
            userdb = Room.databaseBuilder(
                requireContext(),
                UserDatabase::class.java,
                "Notes"
            ).build()
            userdao = userdb.userDao()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener { register(it) }
        binding.backButton.setOnClickListener { backToMain() }
    }

    private fun register(view: View) {
        val username = binding.reqName.text.toString()
        val password = binding.reqPassword.text.toString()
        if (username.isNotEmpty() && password.isNotEmpty()) {
            val user = User(username, password)
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    userdao.insert(user)
                }
                successRegister()
            }
        } else {
            Toast.makeText(this.context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun successRegister() {
        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        findNavController().navigate(action)
        Toast.makeText(requireContext(), "Register Success", Toast.LENGTH_SHORT).show()
    }

    private fun backToMain() {
        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}