package ru.mobile.nzarubin.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel() : ViewModel() {

    private val _state = MutableStateFlow<UiProductModel>(TODO())
    val state: Flow<UiProductModel> = _state

    fun setSearchText(text: String) {
        // TODO()
    }
}