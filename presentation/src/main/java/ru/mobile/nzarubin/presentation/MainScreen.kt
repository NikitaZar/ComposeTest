package ru.mobile.nzarubin.presentation

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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.mobile.nzarubin.designSystem.composable.ClickableIcon

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
) {

    val state = viewModel.state.collectAsState(UiProductModel.idle)

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(6.dp),
    ) {
        item {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = state.value.searchText,
                onValueChange = viewModel::setSearchText,
                leadingIcon = {
                    ClickableIcon(Icons.Rounded.Search) {}
                }
            )
        }
        items(
            items = state.value.items,
            key = { item -> item.id },
            itemContent = { item ->
                ProductCard(
                    item = item,
                    onEdit = {
                        /*TODO*/
                    },
                    onDelete = {
                        /*TODO*/
                    }
                )
            },
        )
    }
}

//@SuppressLint("UnrememberedMutableState")
//@Preview(name = "Main")
//@Composable
//fun MainScreenPreview() {
//    MainScreen(
//        searchTextState = mutableStateOf("ABC"),
//        mobileList = listOf(
//            DomainProductItemModel(
//                id = 1,
//                title = "iPhone 13",
//                amount = 13,
//                date = Date(),
//                tags = listOf("Телефон", "Новый", "Распродажа"),
//            ).mapToUiModel(),
//            DomainProductItemModel(
//                id = 2,
//                title = "Samsung Galaxy S21",
//                amount = 10,
//                date = Date(),
//                tags = listOf("Телефон", "Хит"),
//            ).mapToUiModel(),
//            DomainProductItemModel(
//                id = 3,
//                title = "Playstation 5",
//                amount = 0,
//                date = Date(),
//                tags = listOf("Игровая приставка", "Акция", "Распродажа"),
//            ).mapToUiModel(),
//        ),
//        onSearchTextChange = { },
//    )
//}