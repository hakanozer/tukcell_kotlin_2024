package com.selincengiz.selin_cengiz_odev8.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.selincengiz.selin_cengiz_odev8.R
import com.selincengiz.selin_cengiz_odev8.common.HomeState
import com.selincengiz.selin_cengiz_odev8.databinding.FragmentHomeBinding
import com.selincengiz.selin_cengiz_odev8.domain.entities.RecipeUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), SearchView.OnQueryTextListener, ItemRecipeUIListener {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchView.setOnQueryTextListener(this)
        viewModel.getRecipes()
        observe()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getRecipes()
        observe()
    }

    private fun observe() {
        lifecycleScope.launch {
            viewModel.homeState.collectLatest { state ->
                when (state) {
                    HomeState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is HomeState.Recipes -> {
                        val adaptor = state.list?.let {
                            RecipeAdaptor(
                                this@HomeFragment,
                                requireContext(),
                                it
                            )
                        }
                        binding.listView.adapter = adaptor
                        binding.progressBar.visibility = View.GONE
                    }

                    is HomeState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(
                            requireContext(),
                            state.throwable.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {


                    }
                }
            }
        }
    }

    override fun onQueryTextSubmit(text: String?): Boolean {
        text?.let {
            viewModel.getRecipesByQuery(it)
            println("s$text")
        }
        return true
    }

    override fun onQueryTextChange(text: String?): Boolean {
        text?.let {
            if (it.length > 3) {
                viewModel.getRecipesByQuery(it)
            }
        }
        return true
    }

    override fun onClicked(recipe: RecipeUI) {
        findNavController().navigate(HomeFragmentDirections.homeToDetail(recipe))
    }
}