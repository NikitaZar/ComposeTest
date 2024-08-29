package ru.mobile.nzarubin.presentation

import ru.mobile.domain.DomainProductItemModel
import ru.mobile.nzarubin.utils.toStringDate

data class UiProductItemModel(
    val id: Int,
    val title: String,
    val date: String,
    val tags: List<String>,
    val amount: String,
)

fun DomainProductItemModel.mapToUiModel() = UiProductItemModel(
    id = this.id,
    title = this.title,
    date = this.date.toStringDate(),
    tags = this.tags,
    amount = this.amount.takeIf { it > 0 }?.toString() ?: "Отсутствует", // TODO
)