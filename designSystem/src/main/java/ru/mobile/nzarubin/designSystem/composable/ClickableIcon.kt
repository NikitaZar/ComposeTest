package ru.mobile.nzarubin.designSystem.composable

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ClickableIcon(
    image: ImageVector,
    modifier: Modifier = Modifier,
    @StringRes contentDescription: Int? = null,
    tint: Color = Color.Gray,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            imageVector = image,
            contentDescription = contentDescription?.run {
                stringResource(contentDescription)
            },
            tint = tint,
        )
    }
}

@Preview
@Composable
fun ClickableIconPreview() {
    ClickableIcon(Icons.Rounded.Edit) { }
}