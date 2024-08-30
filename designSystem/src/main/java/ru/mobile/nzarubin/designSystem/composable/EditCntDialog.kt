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
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material.icons.rounded.RemoveCircleOutline
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ru.mobile.nzarubin.designSystem.res.Colors

@Composable
fun EditCountDialog(
    originalCount: Int,
    title: String,
    positiveButtonText: String,
    negativeButtonText: String,
    onEdit: (newCount: Int) -> Unit,
    onCancel: () -> Unit
) {

    val newCount = remember {
        mutableIntStateOf(originalCount)
    }

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
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    ClickableIcon(image = Icons.Rounded.Settings) { }
                    Text(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .padding(bottom = 16.dp),
                        text = title,
                        fontSize = 24.sp,
                        color = Color.Black,
                    )
                    Row(
                        modifier = Modifier.padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        ClickableIcon(
                            image = Icons.Rounded.RemoveCircleOutline,
                            tint = Colors.Blue,
                        ) {
                            if (newCount.intValue != 0) newCount.intValue -= 1
                        }
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = newCount.intValue.toString(),
                            fontSize = 24.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        ClickableIcon(
                            image = Icons.Rounded.AddCircleOutline,
                            tint = Colors.Blue
                        ) {
                            newCount.intValue += 1
                        }
                    }
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
                        TextButton(onClick = { onEdit(newCount.intValue) }) {
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
private fun EditCntDialog_Preview() {
    EditCountDialog(
        originalCount = 1,
        title = "Количество товара",
        positiveButtonText = "Принять",
        negativeButtonText = "Отмена",
        onEdit = {},
        onCancel = {}
    )
}