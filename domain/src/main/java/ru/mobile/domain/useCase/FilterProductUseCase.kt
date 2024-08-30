package ru.mobile.domain.useCase

import kotlinx.coroutines.flow.Flow
import ru.mobile.domain.DomainProductItemModel

interface FilterProductUseCase {
    val domainFlow: Flow<List<DomainProductItemModel>>
    suspend operator fun invoke(textFilter: String)
}