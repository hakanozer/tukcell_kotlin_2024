package com.omersungur.omer_sungur_odev_9.presentation.product_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.omersungur.omer_sungur_odev_9.R
import com.omersungur.omer_sungur_odev_9.core.Resource
import com.omersungur.omer_sungur_odev_9.core.viewBinding
import com.omersungur.omer_sungur_odev_9.databinding.FragmentProductListBinding
import com.omersungur.omer_sungur_odev_9.core.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductListFragment : Fragment(R.layout.fragment_product_list) {

    private val viewModel: ProductViewModel by viewModels()
    private val binding by viewBinding(FragmentProductListBinding::bind)
    private lateinit var adapter: ProductListAdapter

    var isLastPage: Boolean = false
    var isLoading: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        getProducts()
    }

    private fun getProducts() {
        lifecycleScope.launch {
            viewModel.products.collect {
                when (it) {
                    is Resource.Success -> {
                        if (it.data?.products?.isNotEmpty() == true) {
                            println(it.data.products.size)
                            binding.progressBar.visibility = View.INVISIBLE
                            adapter.addProducts(it.data.products)
                            isLoading = false
                        } else {
                            isLastPage = true
                            binding.progressBar.visibility = View.INVISIBLE
                        }
                    }

                    is Resource.Error -> {
                        isLoading = false
                        binding.progressBar.visibility = View.INVISIBLE
                    }

                    is Resource.Loading -> {
                        isLoading = true
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = ProductListAdapter(mutableListOf())

        with(binding) {
            rvProductList.layoutManager = LinearLayoutManager(requireContext())
            rvProductList.adapter = adapter

            rvProductList.addOnScrollListener(object : PaginationScrollListener(rvProductList.layoutManager as LinearLayoutManager) {
                override fun isLastPage(): Boolean {
                    return isLastPage
                }

                override fun isLoading(): Boolean {
                    return isLoading
                }

                override fun loadMoreItems() {
                    isLoading = true
                    viewModel.loadProducts()
                }
            })
        }
    }
}
