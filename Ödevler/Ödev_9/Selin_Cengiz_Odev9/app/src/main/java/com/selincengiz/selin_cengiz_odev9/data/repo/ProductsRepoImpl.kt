package com.selincengiz.selin_cengiz_odev9.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig

import com.selincengiz.selin_cengiz_odev9.data.source.remote.IProductsService
import com.selincengiz.selin_cengiz_odev9.domain.entities.ProductUI
import com.selincengiz.selin_cengiz_odev9.domain.repo.IProductsRepo
import com.selincengiz.selin_cengiz_odev9.paging.ProductPagingSource

class ProductsRepoImpl(private val productsService: IProductsService) : IProductsRepo {
    override fun getProducts(): Pager<Int, ProductUI> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { ProductPagingSource(productsService) }
        )
    }
    }
