package ru.mobile.nzarubin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import ru.mobile.domain.useCase.DeleteItemUseCase
import ru.mobile.domain.useCase.EditAmountUseCase
import ru.mobile.domain.useCase.FilterProductUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val filterProductUseCase: FilterProductUseCase,
    private val editAmountUseCase: EditAmountUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
) : ViewModel() {

    private val _editAmountDialogVisibleFlow = MutableStateFlow(UiProductModel.idle.editAmountDialogState)
    private val _deleteItemDialogStateFlow = MutableStateFlow(UiProductModel.idle.deleteItemDialogState)

    val state: Flow<UiProductModel> = combine(
        filterProductUseCase.domainFlow,
        _editAmountDialogVisibleFlow,
        _deleteItemDialogStateFlow
    ) { filteredProductModel, editAmountDialogState, deleteItemDialogState ->
        UiProductModel(
            searchText = filteredProductModel.textFilter,
            items = filteredProductModel.items.map { domainItem ->
                domainItem.mapToUi()
            },
            editAmountDialogState = editAmountDialogState,
            deleteItemDialogState = deleteItemDialogState,
        )
    }

    fun setSearchText(text: String) {
        viewModelScope.launch {
            filterProductUseCase(text)
        }
    }

    fun showEditAmountDialog(itemId: Int) {
        viewModelScope.launch {
            val amount = editAmountUseCase.getAmount(itemId)

            _editAmountDialogVisibleFlow.emit(
                UiProductModel.EditAmountDialogState(
                    isVisible = true,
                    itemId = itemId,
                    amount = amount
                )
            )
        }
    }

    fun hideEditAmountDialog() {
        viewModelScope.launch {
            _editAmountDialogVisibleFlow.emit(
                UiProductModel.idle.editAmountDialogState
            )
        }
    }

    fun editAmount(newAmount: Int) {
        viewModelScope.launch {
            editAmountUseCase.editAmount(
                itemId = _editAmountDialogVisibleFlow.value.itemId,
                newAmount = newAmount
            )
            hideEditAmountDialog()
        }
    }

    fun showDeleteItemDialog(itemId: Int) {
        viewModelScope.launch {
            _deleteItemDialogStateFlow.emit(
                UiProductModel.DeleteItemDialogState(
                    isVisible = true,
                    itemId = itemId,
                )
            )
        }
    }

    fun hideDeleteItemDialog() {
        viewModelScope.launch {
            _deleteItemDialogStateFlow.emit(
                UiProductModel.idle.deleteItemDialogState
            )
        }
    }

    fun deleteItem() {
        viewModelScope.launch {
            deleteItemUseCase(_deleteItemDialogStateFlow.value.itemId)
            hideDeleteItemDialog()
        }
    }
}
