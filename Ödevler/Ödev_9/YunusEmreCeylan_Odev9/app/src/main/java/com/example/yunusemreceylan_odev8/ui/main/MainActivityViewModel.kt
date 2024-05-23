package com.example.yunusemreceylan_odev8.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.yunusemreceylan_odev8.data.model.Product
import com.example.yunusemreceylan_odev8.domain.usecase.FetchProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val fetchProductsUseCase: FetchProductsUseCase
) : ViewModel() {

    fun getProducts(query: String): Flow<PagingData<Product>> {
        return fetchProductsUseCase(query)
            .cachedIn(viewModelScope)
    }
}
