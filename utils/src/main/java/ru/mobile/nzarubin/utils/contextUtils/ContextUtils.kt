package ru.mobile.nzarubin.utils.contextUtils

import androidx.annotation.StringRes

object ContextUtils {

    private lateinit var sContextUtils: ContextWrapperUtils

    fun init(utils: ContextWrapperUtils) {
        sContextUtils = utils
    }

    fun getString(@StringRes resId: Int): String {
        return sContextUtils.getString(resId)
    }
}
