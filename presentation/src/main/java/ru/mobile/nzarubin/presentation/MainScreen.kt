package ru.mobile.nzarubin.presentation

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mobile.nzarubin.designSystem.R
import ru.mobile.nzarubin.designSystem.composable.ClickableIcon

@Composable
fun MainScreen(
    searchTextState: State<String>,
    @DrawableRes searechIconRes: Int,
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
                ClickableIcon(searechIconRes) {}
            }
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            content = TODO()
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(name = "Main")
@Composable
fun MainScreenPreview() {
    MainScreen(
        searchTextState = mutableStateOf("ABC"),
        mobileListState = mutableStateOf(emptyList()),
        searechIconRes = R.drawable.ic_search_grey_24,
        onSearchTextChange = { },
    )
}