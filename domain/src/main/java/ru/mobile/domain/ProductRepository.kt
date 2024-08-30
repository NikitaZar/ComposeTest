package ru.mobile.domain

interface ProductRepository {
    suspend fun filterProductByName(name: String): List<DomainProductItemModel>
    suspend fun changeAmount(id: Int, newAmount: Int)
    suspend fun deleteProduct(id: Int)
}