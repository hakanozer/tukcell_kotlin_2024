package com.muratdayan.odev9.domain.use_cases

import com.muratdayan.odev9.domain.repository.Repository
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke() = repository.getAllProducts()
}