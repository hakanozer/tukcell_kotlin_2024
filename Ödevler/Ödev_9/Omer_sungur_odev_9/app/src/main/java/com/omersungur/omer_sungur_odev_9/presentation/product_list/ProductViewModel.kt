package com.omersungur.omer_sungur_odev_9.presentation.product_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omersungur.omer_sungur_odev_9.core.Resource
import com.omersungur.omer_sungur_odev_9.data.remote.dto.ProductDtoResult
import com.omersungur.omer_sungur_odev_9.domain.model.Product
import com.omersungur.omer_sungur_odev_9.domain.model.ProductResult
import com.omersungur.omer_sungur_odev_9.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _products = MutableStateFlow<Resource<ProductResult>>(Resource.Loading())
    val products: StateFlow<Resource<ProductResult>> get() = _products

    private var currentPage = 0
    private val pageSize = 10

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            productRepository.getProducts(pageSize, currentPage * pageSize)
                .collect { result ->
                    _products.value = result
                    if (result is Resource.Success && result.data != null) {
                        currentPage++
                    }
                }
        }
    }
}