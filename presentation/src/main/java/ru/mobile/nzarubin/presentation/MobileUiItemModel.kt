package ru.mobile.nzarubin.presentation

import ru.mobile.domain.MobileDomainItemModel
import ru.mobile.nzarubin.utils.toStringDate

data class MobileUiItemModel(
    val id: Int = 0,
    val name: String = "Name",
    val date: String = "01.01.2024",
    val tags: List<String> = listOf("One", "Two", "Three"),
    val amount: String = "Отсутствует", // TODO
)

fun MobileDomainItemModel.mapToUiModel() = MobileUiItemModel(
    id = this.id,
    name = this.name,
    date = this.date.toStringDate(),
    tags = this.tags,
    amount = this.amount.takeIf { it > 0 }?.toString() ?: "Отсутствует", // TODO
)