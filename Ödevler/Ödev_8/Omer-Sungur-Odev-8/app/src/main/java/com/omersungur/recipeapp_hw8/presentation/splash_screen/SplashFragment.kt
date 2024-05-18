package com.omersungur.recipeapp_hw8.presentation.splash_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.omersungur.recipeapp_hw8.R
import com.omersungur.recipeapp_hw8.core.viewBinding
import com.omersungur.recipeapp_hw8.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(2500)
            findNavController().navigate(R.id.action_splashFragment_to_recipeListFragment)
        }
    }
}