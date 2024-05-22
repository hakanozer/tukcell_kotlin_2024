package com.muratdayan.odev9.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.muratdayan.odev9.core.common.Resource
import com.muratdayan.odev9.domain.models.Product
import com.muratdayan.odev9.domain.use_cases.GetAllProductsUseCase
import com.muratdayan.odev9.domain.use_cases.GetAllProductsWithQueryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val getAllProductsWithQueryUseCase: GetAllProductsWithQueryUseCase
) : ViewModel() {


    private val _productState = MutableStateFlow(ProductState())
    val productState : StateFlow<ProductState>
        get() = _productState


    private var currentPage = 0
    private val pageSize = 10
    var isLoadingMoreProducts = false

    init {
        getAllProductsByQuery(pageSize, currentPage*pageSize)
    }

    // limit ve skip değerlerine göre servis çağrısı
    fun getAllProductsByQuery(limit:Int,skip:Int){
        getAllProductsWithQueryUseCase(limit,skip).onEach {resource ->
            when(resource){
                is Resource.Success -> {

                    // yeni gelen verileri productState'e ekle
                    val currentProducts = _productState.value.products ?: emptyList()
                    val newProducts = currentProducts + (resource.data ?: emptyList())
                    _productState.value = ProductState(products = newProducts)
                    isLoadingMoreProducts = false
                }
                is Resource.Error -> {
                    _productState.value = ProductState(errorMsg = resource.msg)
                }
                is Resource.Loading -> {
                    _productState.value = ProductState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }

    // bir current page değişkeni tutup bunu her arttırdıgımızda skip değerimiz 10 artacak ve yeni servis çağrısı yapacak
    fun loadMoreProducts() {

        if (isLoadingMoreProducts) return
        isLoadingMoreProducts = true
        currentPage++
        getAllProductsByQuery(pageSize, currentPage * pageSize)
    }

    // TÜM VERİLERİ GETİRİR
    /*private fun getAllProducts(){


        getAllProductsUseCase().onEach {resource ->
            when(resource){
                is Resource.Success -> {
                    _productState.value = ProductState(products = resource.data)
                }
                is Resource.Error -> {
                    _productState.value = ProductState(errorMsg = resource.msg)
                }
                is Resource.Loading -> {
                    _productState.value = ProductState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }*/

}