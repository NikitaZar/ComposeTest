package ru.mobile.nzarubin.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mobile.nzarubin.designSystem.R
import ru.mobile.nzarubin.designSystem.composable.ClickableIcon
import ru.mobile.nzarubin.designSystem.res.Colors

@Composable
fun MobileCard(
    uiModel: MobileUiItemModel,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 6.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 6.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = uiModel.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Row {
                        ClickableIcon(
                            image = Icons.Rounded.Edit,
                            tint = Colors.Purple,

                            ) {
                            onEdit.invoke()
                        }
                        ClickableIcon(
                            image = Icons.Rounded.Delete,
                            tint = Colors.Orange,
                        ) {
                            onDelete.invoke()
                        }
                    }
                }
                Row {
                    uiModel.tags.forEach {
                        FilterChip(
                            modifier = Modifier.padding(end = 6.dp),
                            selected = false,
                            onClick = { },
                            label = { Text(it) },
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = stringResource(id = R.string.on_stock),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 6.dp),
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = uiModel.amount,
                            fontSize = 16.sp,
                        )
                    }
                    Column {
                        Text(
                            text = stringResource(id = R.string.date_added),
                            modifier = Modifier.padding(vertical = 6.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = uiModel.date,
                            fontSize = 16.sp,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductCard_Preview() {
    MobileCard(uiModel = MobileUiItemModel(), onEdit = {}, onDelete = {})
}