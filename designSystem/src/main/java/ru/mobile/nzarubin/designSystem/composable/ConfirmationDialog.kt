package ru.mobile.nzarubin.designSystem.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ru.mobile.nzarubin.designSystem.res.Colors

@Composable
fun ConfirmationDialog(
    image: ImageVector?,
    title: String?,
    message: String,
    positiveButtonText: String,
    negativeButtonText: String,
    onConfirm: () -> Unit,
    onCancel: () -> Unit
) {

    Dialog(onDismissRequest = onCancel) {
        Card(
            modifier = Modifier.height(270.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    image?.run {
                        ClickableIcon(image = image) { }
                    }
                    title?.run {
                        Text(
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .padding(bottom = 16.dp),
                            text = title,
                            fontSize = 24.sp,
                            color = Color.Black,
                        )
                    }
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = message,
                        fontSize = 14.sp,
                        color = Color.Black,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        TextButton(onClick = onCancel) {
                            Text(
                                text = negativeButtonText,
                                color = Colors.Blue,
                            )
                        }
                        TextButton(onClick = { onConfirm() }) {
                            Text(
                                text = positiveButtonText,
                                color = Colors.Blue
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ConfirmationDialog_Preview() {
    ConfirmationDialog(
        image = Icons.Filled.Warning,
        title = "Удаление товаров",
        message = "Вы действительно хотите удалить выбранный товар?",
        positiveButtonText = "Да",
        negativeButtonText = "Нет",
        onConfirm = {},
        onCancel = {}
    )
}