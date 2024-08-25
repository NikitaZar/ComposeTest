package ru.mobile.nzarubin.designSystem.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ru.mobile.nzarubin.designSystem.R

@Composable
fun ClickableIcon(
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Icon(
        painter = painterResource(id = iconRes),
        contentDescription = null,
        modifier = modifier.clickable { onClick.invoke() }
    )
}

@Preview
@Composable
fun ClickableIconPreview() {
    ClickableIcon(R.drawable.ic_search_grey_24) { }
}