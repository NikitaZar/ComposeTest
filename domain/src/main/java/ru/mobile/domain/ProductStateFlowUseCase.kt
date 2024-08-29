package ru.mobile.domain

import kotlinx.coroutines.flow.Flow

interface ProductStateFlowUseCase {
    val domainFlow: Flow<List<DomainProductItemModel>>
}