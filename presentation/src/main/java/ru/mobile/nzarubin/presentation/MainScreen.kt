package ru.mobile.nzarubin.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.mobile.nzarubin.designSystem.composable.ClickableIcon

@Composable
fun MainScreen(
    searchTextState: State<String>,
    mobileListState: State<List<UiMobileItemState>>,
    onSearchTextChange: (String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier,
            value = searchTextState.value,
            onValueChange = onSearchTextChange,
            leadingIcon = {
                ClickableIcon(Icons.Rounded.Search) {}
            }
        )
        LazyColumn {
            TODO()
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(name = "Main")
@Composable
fun MainScreenPreview() {
    MainScreen(
        searchTextState = mutableStateOf("ABC"),
        mobileListState = mutableStateOf(emptyList()),
        onSearchTextChange = { },
    )
}