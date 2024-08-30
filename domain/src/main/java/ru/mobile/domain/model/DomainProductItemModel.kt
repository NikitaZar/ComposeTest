package ru.mobile.domain.model

import java.util.Date

data class DomainProductItemModel(
    val id: Int,
    val title: String,
    val date: Date,
    val tags: List<String>,
    val amount: Int,
)
