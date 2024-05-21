package com.omersungur.omer_sungur_vize_3.presentation.user_list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.omersungur.omer_sungur_vize_3.R
import com.omersungur.omer_sungur_vize_3.core.Resource
import com.omersungur.omer_sungur_vize_3.core.customToast
import com.omersungur.omer_sungur_vize_3.core.viewBinding
import com.omersungur.omer_sungur_vize_3.databinding.FragmentUserListBinding
import com.omersungur.omer_sungur_vize_3.presentation.common.SharedUserListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListFragment : Fragment(R.layout.fragment_user_list) {

    private val binding by viewBinding(FragmentUserListBinding::bind)
    private val viewModel: SharedUserListViewModel by activityViewModels()
    private lateinit var userListAdapter: UserListRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        setupMenu()
        getUsers()
    }

    private fun getUsers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.filteredUsers.collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            with(binding) {
                                progressBar.visibility = View.INVISIBLE
                                userListAdapter = UserListRecyclerAdapter(requireContext(), result.data!!.users)
                                rvUserList.layoutManager = LinearLayoutManager(requireContext())
                                rvUserList.adapter = userListAdapter
                            }
                        }

                        is Resource.Error -> {
                            requireContext().customToast("Error: ${result.message}")
                        }

                        is Resource.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    private fun setupMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.app_options_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.userFilterFragment -> {
                        findNavController().navigate(R.id.action_userListFragment_to_userFilterFragment)
                        true
                    }

                    R.id.clearFilteredList -> {
                        viewModel.resetFilters()
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}
