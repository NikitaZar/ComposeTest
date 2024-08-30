package ru.mobile.domain.useCase

interface EditAmountUseCase {
    suspend fun editAmount(itemId: Int, newAmount: Int)
    suspend fun getAmount(itemId: Int): Int
}
