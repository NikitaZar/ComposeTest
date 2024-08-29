package ru.mobile.domain.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.mobile.domain.DomainProductItemModel
import ru.mobile.domain.ProductStateFlowUseCase
import java.util.Date

internal class ProductStateFlowUseCaseImpl : ProductStateFlowUseCase {
    override val domainFlow: Flow<List<DomainProductItemModel>>
        get() = flowOf(
            listOf(
                DomainProductItemModel(
                    id = 1,
                    title = "iPhone 13",
                    amount = 13,
                    date = Date(),
                    tags = listOf("Телефон", "Новый", "Распродажа"),
                ),
                DomainProductItemModel(
                    id = 2,
                    title = "Samsung Galaxy S21",
                    amount = 10,
                    date = Date(),
                    tags = listOf("Телефон", "Хит"),
                ),
                DomainProductItemModel(
                    id = 3,
                    title = "Playstation 5",
                    amount = 0,
                    date = Date(),
                    tags = listOf("Игровая приставка", "Акция", "Распродажа"),
                ),
            )
        ) // TODO
}