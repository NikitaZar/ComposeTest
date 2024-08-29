package ru.mobile.nzarubin.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mobile.domain.DomainProductItemModel
import ru.mobile.nzarubin.designSystem.composable.ClickableIcon
import java.util.Date

@Composable
fun MainScreen(
    searchTextState: State<String>,
    mobileList: List<UiProductItemModel>,
    onSearchTextChange: (String) -> Unit,
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(6.dp),
    ) {
        item {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = searchTextState.value,
                onValueChange = onSearchTextChange,
                leadingIcon = {
                    ClickableIcon(Icons.Rounded.Search) {}
                }
            )
        }
        items(mobileList) { item ->
            ProductCard(
                item = item,
                onEdit = {
                    /*TODO*/
                },
                onDelete = {
                    /*TODO*/
                }
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(name = "Main")
@Composable
fun MainScreenPreview() {
    MainScreen(
        searchTextState = mutableStateOf("ABC"),
        mobileList = listOf(
            DomainProductItemModel(
                id = 1,
                title = "iPhone 13",
                amount = 13,
                date = Date(),
                tags = listOf("Телефон", "Новый", "Распродажа"),
            ).mapToUiModel(),
            DomainProductItemModel(
                id = 2,
                title = "Samsung Galaxy S21",
                amount = 10,
                date = Date(),
                tags = listOf("Телефон", "Хит"),
            ).mapToUiModel(),
            DomainProductItemModel(
                id = 3,
                title = "Playstation 5",
                amount = 0,
                date = Date(),
                tags = listOf("Игровая приставка", "Акция", "Распродажа"),
            ).mapToUiModel(),
        ),
        onSearchTextChange = { },
    )
}