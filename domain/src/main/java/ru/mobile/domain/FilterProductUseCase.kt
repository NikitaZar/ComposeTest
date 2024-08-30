package ru.mobile.domain

import kotlinx.coroutines.flow.Flow

interface FilterProductUseCase {
    val domainFlow: Flow<List<DomainProductItemModel>>
    suspend operator fun invoke(textFilter: String)
}