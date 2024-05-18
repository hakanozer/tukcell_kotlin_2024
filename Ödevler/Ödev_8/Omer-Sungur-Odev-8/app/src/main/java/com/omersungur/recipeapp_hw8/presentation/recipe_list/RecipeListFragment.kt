package com.omersungur.recipeapp_hw8.presentation.recipe_list

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.omersungur.recipeapp_hw8.R
import com.omersungur.recipeapp_hw8.core.Resource
import com.omersungur.recipeapp_hw8.core.customToast
import com.omersungur.recipeapp_hw8.core.viewBinding
import com.omersungur.recipeapp_hw8.databinding.FragmentRecipeListBinding
import com.omersungur.recipeapp_hw8.domain.model.RecipeResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeListFragment : Fragment(R.layout.fragment_recipe_list) {

    private val binding by viewBinding(FragmentRecipeListBinding::bind)
    private val viewModel: RecipeListViewModel by viewModels()
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
    }

    private fun getData() {
        lifecycleScope.launch {
            viewModel.recipe.collect { result ->
                when (result) {
                    is Resource.Success -> {
                        with(binding) {
                            progressBar.visibility = View.GONE
                            listView.visibility = View.VISIBLE

                            result.data?.recipes?.let { recipeListResult ->
                                recipeAdapter = RecipeAdapter(requireActivity(), recipeListResult)
                                listView.adapter = recipeAdapter

                                searchRecipe(recipeListResult)
                            }
                        }
                    }

                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        requireContext().customToast(result.message.toString())
                    }

                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.listView.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun searchRecipe(recipeList: List<RecipeResult>) {
        with(binding) {
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    val filteredList = viewModel.filterRecipe(
                        newText, recipeList = recipeList
                    )

                    recipeAdapter = RecipeAdapter(requireActivity(), filteredList)
                    listView.adapter = recipeAdapter
                    return false
                }
            })
        }
    }
}
