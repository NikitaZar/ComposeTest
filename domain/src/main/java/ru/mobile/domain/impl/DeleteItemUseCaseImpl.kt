package ru.mobile.domain.impl

import ru.mobile.domain.ProductRepository
import ru.mobile.domain.useCase.DeleteItemUseCase
import javax.inject.Inject

internal class DeleteItemUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : DeleteItemUseCase {

    override suspend fun invoke(itemId: Int) {
        productRepository.deleteProduct(itemId)
    }
}