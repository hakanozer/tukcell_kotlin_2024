package com.muratdayan.odev9.data.remote.repository


import com.muratdayan.odev9.core.common.Resource
import com.muratdayan.odev9.data.remote.mapper.toProduct
import com.muratdayan.odev9.data.remote.services.IDummyService
import com.muratdayan.odev9.domain.models.Product
import com.muratdayan.odev9.domain.repository.Repository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@ViewModelScoped
class RepositoryImpl @Inject constructor(
    private val iDummyService: IDummyService
) : Repository {
    override fun getAllProducts(): Flow<Resource<List<Product>>> = flow {

        emit(Resource.Loading())

        val productListDto = iDummyService.getAllProducts().products

        val productList = productListDto.map {
            it.toProduct()
        }
        emit(Resource.Success(productList))

    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }

    override fun getAllProductsWithQuery(limit: Int, skip: Int): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())

        val productListDto = iDummyService.getAllProductsWithQuery(limit, skip).products

        val productList = productListDto.map {
            it.toProduct()
        }
        emit(Resource.Success(productList))

    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }


}