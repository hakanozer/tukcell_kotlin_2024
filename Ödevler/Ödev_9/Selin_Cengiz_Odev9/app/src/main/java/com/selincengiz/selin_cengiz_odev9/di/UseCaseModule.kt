package com.selincengiz.selin_cengiz_odev9.di

import com.selincengiz.selin_cengiz_odev9.data.repo.ProductsRepoImpl
import com.selincengiz.selin_cengiz_odev9.data.source.remote.IProductsService
import com.selincengiz.selin_cengiz_odev9.domain.repo.IProductsRepo
import com.selincengiz.selin_cengiz_odev9.domain.usecase.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideProductsUseCase(productRepo: IProductsRepo): GetProductsUseCase =
        GetProductsUseCase(repository = productRepo)

}