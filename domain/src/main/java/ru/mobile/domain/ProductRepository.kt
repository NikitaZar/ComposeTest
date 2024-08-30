package ru.mobile.domain

import kotlinx.coroutines.flow.Flow
import ru.mobile.domain.model.DomainProductModel

interface ProductRepository {
    val filteredFlow: Flow<DomainProductModel>
    suspend fun filterProductByName(filterName: String)
    suspend fun changeAmount(id: Int, newAmount: Int)
    suspend fun getAmount(id: Int): Int
    suspend fun deleteProduct(id: Int)
}
