package com.selincengiz.selin_cengiz_odev9.domain.repo

import androidx.paging.Pager
import com.selincengiz.selin_cengiz_odev9.domain.entities.ProductUI

interface IProductsRepo {
     fun getProducts(): Pager<Int, ProductUI>
}