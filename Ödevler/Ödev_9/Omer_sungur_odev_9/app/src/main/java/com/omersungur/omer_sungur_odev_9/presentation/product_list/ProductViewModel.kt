package com.omersungur.omer_sungur_odev_9.presentation.product_list

import androidx.lifecycle.ViewModel
import com.omersungur.omer_sungur_odev_9.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel() {

    val getProducts = productRepository.getProducts()
}