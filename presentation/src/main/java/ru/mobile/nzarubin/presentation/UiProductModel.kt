package ru.mobile.nzarubin.presentation

import ru.mobile.nzarubin.utils.empty

data class UiProductModel(
    val searchText: String,
    val items: List<UiProductItemModel>,
    val editAmountDialogState: EditAmountDialogState,
    val deleteItemDialogState: DeleteItemDialogState,
) {
    companion object {
        val idle = UiProductModel(
            searchText = String.empty,
            items = emptyList(),
            editAmountDialogState = EditAmountDialogState(isVisible = false, itemId = 0, amount = 0),
            deleteItemDialogState = DeleteItemDialogState(isVisible = false, itemId = 0),
        )
    }

    data class EditAmountDialogState(
        val isVisible: Boolean,
        val itemId: Int,
        val amount: Int,
    )

    data class DeleteItemDialogState(
        val isVisible: Boolean,
        val itemId: Int,
    )
}
