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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductListFragment : Fragment(R.layout.fragment_product_list) {

    private val viewModel: ProductViewModel by viewModels()
    private val binding by viewBinding(FragmentProductListBinding::bind)
    private lateinit var adapter: ProductListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.getProducts.collect {
                when(it) {
                    is Resource.Success -> {
                        println(it.data?.products!!.size)
                        adapter = ProductListAdapter(it.data?.products!!)
                        binding.rvProductList.layoutManager = LinearLayoutManager(requireContext())
                        binding.rvProductList.adapter = adapter
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {

                    }
                }
            }
        }
    }
}