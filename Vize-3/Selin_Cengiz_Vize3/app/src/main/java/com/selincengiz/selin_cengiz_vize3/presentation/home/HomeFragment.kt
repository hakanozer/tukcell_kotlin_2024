package com.selincengiz.selin_cengiz_vize3.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.selincengiz.selin_cengiz_vize3.R
import com.selincengiz.selin_cengiz_vize3.common.HomeState
import com.selincengiz.selin_cengiz_vize3.databinding.FragmentHomeBinding
import com.selincengiz.selin_cengiz_vize3.domain.entities.UserUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private val adapter by lazy { UserAdapter(::onUserClick) }
    private val args by navArgs<HomeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.recyclerUser.adapter = adapter
        binding.homeFragment = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (args.value == "value" && args.key == "key") {
            viewModel.getUsers()
        } else {
            viewModel.filterUsers(args.key, args.value)
        }

        observe()
    }

    private fun observe() {
        lifecycleScope.launch {
            viewModel.homeState.collectLatest { state ->
                when (state) {
                    HomeState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is HomeState.Users -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.submitList(state.list)
                    }

                    is HomeState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(
                            requireContext(),
                            state.throwable.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {}
                }
            }
        }
    }

    fun onFilterClick() {
        findNavController().navigate(HomeFragmentDirections.homeToFilter())
    }


    private fun onUserClick(user: UserUI) {
        findNavController().navigate(HomeFragmentDirections.homeToDetail(user))
    }
}