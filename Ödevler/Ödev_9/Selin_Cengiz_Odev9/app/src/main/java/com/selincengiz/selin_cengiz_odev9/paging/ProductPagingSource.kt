package com.selincengiz.selin_cengiz_odev9.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.selincengiz.selin_cengiz_odev9.data.mapper.mapToProductUI
import com.selincengiz.selin_cengiz_odev9.data.source.remote.IProductsService
import com.selincengiz.selin_cengiz_odev9.domain.entities.ProductUI

class ProductPagingSource(private val apiService: IProductsService) : PagingSource<Int, ProductUI>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductUI> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getProducts(currentPage, params.loadSize)
            val items = response.products!!.map { item -> item.mapToProductUI()}

            LoadResult.Page(
                data = items,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (items.isEmpty()) null else currentPage + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ProductUI>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}