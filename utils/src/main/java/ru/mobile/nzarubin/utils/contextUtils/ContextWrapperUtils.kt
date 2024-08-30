package ru.mobile.nzarubin.utils.contextUtils

import androidx.annotation.StringRes

interface ContextWrapperUtils {

    fun getString(@StringRes resId: Int): String
}
