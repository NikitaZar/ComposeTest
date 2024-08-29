package ru.mobile.nzarubin.presentation

import ru.mobile.nzarubin.utils.empty

data class UiProductModel(
    val searchText: String,
    val items: List<UiProductItemModel>,
) {
    companion object {
        val idle = UiProductModel(
            searchText = String.empty,
            items = emptyList(),
        )
    }
}
