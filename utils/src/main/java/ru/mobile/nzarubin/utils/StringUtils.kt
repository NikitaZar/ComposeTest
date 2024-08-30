package ru.mobile.nzarubin.utils

import androidx.annotation.StringRes
import ru.mobile.nzarubin.utils.contextUtils.ContextUtils

val String.Companion.empty get() = ""

fun string(@StringRes resId: Int) = ContextUtils.getString(resId)