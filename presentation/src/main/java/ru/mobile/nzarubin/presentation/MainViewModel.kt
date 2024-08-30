package ru.mobile.nzarubin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import ru.mobile.domain.useCase.EditAmountUseCase
import ru.mobile.domain.useCase.FilterProductUseCase
import ru.mobile.nzarubin.utils.empty
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val filterProductUseCase: FilterProductUseCase,
    private val editAmountUseCase: EditAmountUseCase,
) : ViewModel() {

    init {
        viewModelScope.launch {
            filterProductUseCase(String.empty)
        }
    }

    private val _editAmountDialogVisibleFlow = MutableStateFlow(UiProductModel.idle.editAmountDialogState)

    val state: Flow<UiProductModel> = combine(
        filterProductUseCase.domainFlow,
        _editAmountDialogVisibleFlow,
    ) { filteredProductsModel, editAmountDialogState ->
        UiProductModel(
            searchText = filteredProductsModel.textFilter,
            items = filteredProductsModel.items.map { domainItem ->
                domainItem.mapToUi()
            },
            editAmountDialogState = editAmountDialogState,
            isDeleteDialogVisible = false,
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
}