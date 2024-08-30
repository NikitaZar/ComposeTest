package ru.mobile.domain.model

data class DomainProductModel(
    val textFilter: String,
    val items: List<DomainProductItemModel>,
)
