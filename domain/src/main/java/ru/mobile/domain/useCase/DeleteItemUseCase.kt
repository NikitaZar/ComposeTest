package ru.mobile.domain.useCase

interface DeleteItemUseCase {
    suspend operator fun invoke(itemId: Int)
}
