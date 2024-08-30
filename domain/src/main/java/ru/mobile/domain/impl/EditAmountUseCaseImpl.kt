package ru.mobile.domain.impl

import ru.mobile.domain.ProductRepository
import ru.mobile.domain.useCase.EditAmountUseCase
import javax.inject.Inject

internal class EditAmountUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : EditAmountUseCase {

    override suspend fun editAmount(itemId: Int, newAmount: Int) {
        productRepository.changeAmount(itemId, newAmount)
    }

    override suspend fun getAmount(itemId: Int): Int {
        return productRepository.getAmount(itemId)
    }
}