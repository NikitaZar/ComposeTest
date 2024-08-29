package ru.mobile.nzarubin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import ru.mobile.domain.FilterProductUseCase
import ru.mobile.domain.ProductStateFlowUseCase
import ru.mobile.nzarubin.utils.empty
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val filterProductUseCase: FilterProductUseCase,
    productStateFlowUseCase: ProductStateFlowUseCase,
) : ViewModel() {

    private val _searchTextStateFlow = MutableStateFlow(String.empty)

    val state: Flow<UiProductModel> = combine(
        productStateFlowUseCase.domainFlow,
        _searchTextStateFlow,
    ) { productList, searchText ->
        UiProductModel(
            searchText = searchText,
            items = productList.map { domainItem ->
                domainItem.mapToUi()
            },
        )
    }

    fun setSearchText(text: String) {
        viewModelScope.launch {
            _searchTextStateFlow.emit(text)
            filterProductUseCase(text)
        }
    }
}