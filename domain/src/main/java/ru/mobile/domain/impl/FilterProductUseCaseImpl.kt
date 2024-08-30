package ru.mobile.domain.impl

import kotlinx.coroutines.flow.Flow
import ru.mobile.domain.ProductRepository
import ru.mobile.domain.model.DomainProductModel
import ru.mobile.domain.useCase.FilterProductUseCase
import javax.inject.Inject

internal class FilterProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : FilterProductUseCase {

    override val domainFlow: Flow<DomainProductModel> = productRepository.filteredFlow

    override suspend fun invoke(textFilter: String) {
        productRepository.filterProductByName(textFilter)
    }
}
