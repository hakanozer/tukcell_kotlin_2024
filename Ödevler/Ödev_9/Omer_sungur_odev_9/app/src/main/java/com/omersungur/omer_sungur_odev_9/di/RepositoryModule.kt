package com.omersungur.omer_sungur_odev_9.di

import com.omersungur.omer_sungur_odev_9.data.remote.ProductService
import com.omersungur.omer_sungur_odev_9.data.repository.ProductRepositoryImpl
import com.omersungur.omer_sungur_odev_9.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(productService: ProductService): ProductRepository {
        return ProductRepositoryImpl(productService)
    }
}