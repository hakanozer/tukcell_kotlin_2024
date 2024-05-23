package com.selincengiz.selin_cengiz_odev9.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.selincengiz.selin_cengiz_odev9.domain.entities.ProductUI
import com.selincengiz.selin_cengiz_odev9.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    val products: LiveData<PagingData<ProductUI>> = getProductsUseCase()
        .cachedIn(viewModelScope)
        .asLiveData()
}