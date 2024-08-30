package ru.mobile.domain.useCase

import kotlinx.coroutines.flow.Flow
import ru.mobile.domain.model.DomainProductModel

interface FilterProductUseCase {
    val domainFlow: Flow<DomainProductModel>
    suspend operator fun invoke(textFilter: String)
}