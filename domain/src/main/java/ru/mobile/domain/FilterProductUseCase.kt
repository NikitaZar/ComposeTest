package ru.mobile.domain

interface FilterProductUseCase {
    suspend operator fun invoke(textFilter: String)
}