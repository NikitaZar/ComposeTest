package ru.mobile.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.mobile.data.db.ProductDao
import ru.mobile.data.mappers.ProductItemMapper
import ru.mobile.domain.DomainProductItemModel
import ru.mobile.domain.ProductRepository
import javax.inject.Inject

internal class ProductRepositoryImpl @Inject constructor(
    private val dao: ProductDao,
    private val mapper: ProductItemMapper,
) : ProductRepository {

    override suspend fun filterProductByName(name: String): List<DomainProductItemModel> {
        return withContext(Dispatchers.IO) {
            dao.getFilteredProducts(name).map(mapper::mapToDomain)
        }
    }

    override suspend fun changeAmount(id: Int, newAmount: Int) {
        withContext(Dispatchers.IO) {
            dao.updateAmountById(id, newAmount)
        }
    }

    override suspend fun deleteProduct(id: Int) {
        withContext(Dispatchers.IO) {
            dao.deleteProductById(id)
        }
    }
}