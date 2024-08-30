package ru.mobile.nzarubin.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.mobile.nzarubin.designSystem.R
import ru.mobile.nzarubin.designSystem.composable.ClickableIcon
import ru.mobile.nzarubin.designSystem.composable.ConfirmationDialog
import ru.mobile.nzarubin.designSystem.composable.EditCountDialog
import ru.mobile.nzarubin.designSystem.res.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
) {

    val state = viewModel.state.collectAsState(UiProductModel.idle)
    Column {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.product_list),
                    textAlign = TextAlign.Center,
                )
            },
            colors = TopAppBarColors(
                containerColor = Colors.BackgroundBlue,
                scrolledContainerColor = Colors.BackgroundBlue,
                navigationIconContentColor = Color.Black,
                titleContentColor = Color.Black,
                actionIconContentColor = Color.Black
            ),
        )

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
                            viewModel.showEditAmountDialog(item.id)
                        },
                        onDelete = {
                            viewModel.showDeleteItemDialog(item.id)
                        }
                    )
                },
            )
        }
    }

    with(state.value.editAmountDialogState) {
        if (isVisible) {
            EditCountDialog(
                originalCount = amount,
                title = stringResource(R.string.product_amount),
                positiveButtonText = stringResource(R.string.confirm),
                negativeButtonText = stringResource(R.string.cancel),
                onEdit = { newAmount ->
                    viewModel.editAmount(newAmount)
                },
                onCancel = {
                    viewModel.hideEditAmountDialog()
                }
            )
        }
    }

    with(state.value.deleteItemDialogState) {
        if (isVisible) {
            ConfirmationDialog(
                image = Icons.Filled.Warning,
                title = stringResource(R.string.products_removing),
                message = stringResource(R.string.products_removing_message),
                positiveButtonText = stringResource(R.string.yes),
                negativeButtonText = stringResource(R.string.no),
                onConfirm = {
                    viewModel.deleteItem()
                },
                onCancel = {
                    viewModel.hideDeleteItemDialog()
                },
            )
        }
    }
}
