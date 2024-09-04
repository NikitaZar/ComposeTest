package ru.mobile.nzarubin.designSystem.res

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

@Composable
fun Theme(content: @Composable () -> Unit) {
    val view = LocalView.current
    if (!LocalView.current.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val backGroundColorArgb = Colors.BackgroundBlue.toArgb()
            window.statusBarColor = backGroundColorArgb
            window.navigationBarColor = backGroundColorArgb
        }
    }

    MaterialTheme(
        content = content
    )
}
