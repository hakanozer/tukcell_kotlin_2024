package com.muratdayan.odev10.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.muratdayan.odev10.R
import com.muratdayan.odev10.common.components.UserSharedPrefManager
import com.muratdayan.odev10.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var userSharedPrefManager: UserSharedPrefManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        userSharedPrefManager = UserSharedPrefManager(requireContext())
        val username = userSharedPrefManager.getUserName()

        if (username.isNullOrEmpty()){
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.navigate_splashFragment_to_loginFragment)
            }, 1000) // 1 saniye beklet
        } else {
            // Kullanıcı adı doluysa, 1saniye sonra NotesFragment'e git
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.navigate_splashFragment_to_notesFragment)
            }, 1000) // 1 saniye beklet
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}