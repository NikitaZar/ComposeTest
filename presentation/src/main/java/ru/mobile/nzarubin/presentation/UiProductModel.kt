package ru.mobile.nzarubin.presentation

import ru.mobile.nzarubin.utils.empty

data class UiProductModel(
    val searchText: String,
    val items: List<UiProductItemModel>,
    val editAmountDialogState: EditAmountDialogState,
    val isDeleteDialogVisible: Boolean,
) {
    companion object {
        val idle = UiProductModel(
            searchText = String.empty,
            items = emptyList(),
            editAmountDialogState = EditAmountDialogState(isVisible = false, itemId = 0, amount = 0),
            isDeleteDialogVisible = false,
        )
    }

    data class EditAmountDialogState(
        val isVisible: Boolean,
        val itemId: Int,
        val amount: Int,
    )
}
