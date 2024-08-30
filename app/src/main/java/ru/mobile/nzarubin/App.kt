package ru.mobile.nzarubin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.mobile.nzarubin.utils.contextUtils.ContextUtils
import ru.mobile.nzarubin.utils.contextUtils.ContextWrapperUtils

@HiltAndroidApp
class App : Application(), ContextWrapperUtils {

    override fun onCreate() {
        super.onCreate()
        ContextUtils.init(this)
    }
}
