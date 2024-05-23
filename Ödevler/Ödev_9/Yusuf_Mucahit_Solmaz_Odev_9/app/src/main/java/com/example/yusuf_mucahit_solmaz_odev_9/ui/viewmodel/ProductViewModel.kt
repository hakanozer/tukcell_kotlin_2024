package com.example.yusuf_mucahit_solmaz_odev_9.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yusuf_mucahit_solmaz_odev_9.core.utils.Resource
import com.example.yusuf_mucahit_solmaz_odev_9.data.remote.model.Product
import com.example.yusuf_mucahit_solmaz_odev_9.data.remote.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _products = MutableLiveData<Resource<List<Product>>>()
    val products: LiveData<Resource<List<Product>>> get() = _products

    private var currentPage = 0
    private val pageSize = 10

    init {
        loadProducts()
    }

    fun loadProducts() {
        if (_products.value is Resource.Loading) return

        _products.value = Resource.Loading()
        viewModelScope.launch {
            try {
                val response = repository.getProducts(pageSize, currentPage * pageSize)
                val updatedProducts = (_products.value?.data ?: emptyList()) + response.products
                _products.value = Resource.Success(updatedProducts)
                currentPage++
            } catch (e: Exception) {
                _products.value = Resource.Error(e.message ?: "An unknown error occurred")
            }
        }
    }
}