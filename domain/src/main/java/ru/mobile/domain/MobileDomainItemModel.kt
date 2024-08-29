package ru.mobile.domain

import java.util.Date

data class MobileDomainItemModel(
    val id: Int,
    val name: String,
    val date: Date,
    val tags: List<String>,
    val amount: Int,
)
