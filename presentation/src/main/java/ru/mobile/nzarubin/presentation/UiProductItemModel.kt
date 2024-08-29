package ru.mobile.nzarubin.presentation

import ru.mobile.domain.DomainProductItemModel
import ru.mobile.nzarubin.utils.toStringDate

data class UiProductItemModel(
    val id: Int = 0,
    val title: String = "Name",
    val date: String = "01.01.2024",
    val tags: List<String> = listOf("One", "Two", "Three"),
    val amount: String = "Отсутствует", // TODO
)

fun DomainProductItemModel.mapToUiModel() = UiProductItemModel(
    id = this.id,
    title = this.title,
    date = this.date.toStringDate(),
    tags = this.tags,
    amount = this.amount.takeIf { it > 0 }?.toString() ?: "Отсутствует", // TODO
)