package ru.mobile.domain.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.mobile.domain.DomainProductItemModel
import ru.mobile.domain.FilterProductUseCase
import ru.mobile.domain.ProductRepository
import javax.inject.Inject

internal class FilterProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : FilterProductUseCase {

    private val _domainFlow = MutableStateFlow<List<DomainProductItemModel>>(emptyList())
    override val domainFlow: Flow<List<DomainProductItemModel>> = _domainFlow

    override suspend fun invoke(textFilter: String) {
        productRepository.filterProductByName(textFilter).let { filteredProducts ->
            _domainFlow.emit(filteredProducts)
        }
    }
}