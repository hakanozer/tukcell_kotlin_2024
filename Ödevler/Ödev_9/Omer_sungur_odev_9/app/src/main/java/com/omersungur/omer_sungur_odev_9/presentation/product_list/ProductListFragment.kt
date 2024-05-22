package com.omersungur.omer_sungur_odev_9.presentation.product_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.omersungur.omer_sungur_odev_9.core.Resource
import kotlinx.coroutines.launch

class ProductListFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.getProducts.collect {
                when(it) {
                    is Resource.Success -> {
                        println(it.data?.products?.size)
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