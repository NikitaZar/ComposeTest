package ru.mobile.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.withContext
import ru.mobile.data.db.ProductDao
import ru.mobile.data.mappers.ProductItemMapper
import ru.mobile.domain.ProductRepository
import ru.mobile.domain.model.DomainProductModel
import ru.mobile.nzarubin.utils.empty
import javax.inject.Inject

internal class ProductRepositoryImpl @Inject constructor(
    private val dao: ProductDao,
    private val mapper: ProductItemMapper,
) : ProductRepository {

    private val _textFilterFlow = MutableStateFlow(String.empty)

    override val filteredFlow: Flow<DomainProductModel> = combine(
        dao.getAllProductsFlow(),
        _textFilterFlow,
    ) { _, textFilter ->
        withContext(Dispatchers.IO) {
            DomainProductModel(
                textFilter = textFilter,
                items = dao.getFilteredProducts(textFilter).map(mapper::mapToDomain)
            )
        }
    }

    override suspend fun filterProductByName(filterName: String) {
        _textFilterFlow.emit(filterName)
    }

    override suspend fun changeAmount(id: Int, newAmount: Int) {
        withContext(Dispatchers.IO) {
            dao.updateAmountById(id, newAmount)
        }
    }

    override suspend fun getAmount(id: Int): Int {
        return withContext(Dispatchers.IO) {
            dao.getAmountByItemId(id)
        }
    }

    override suspend fun deleteProduct(id: Int) {
        withContext(Dispatchers.IO) {
            dao.deleteProductById(id)
        }
    }
}
