import org.gradle.api.JavaVersion

object AndroidSdk {
    const val minSdk = 23
    const val compileSdk = 34
    const val targetSdk = compileSdk
}

const val kotlinCompilerExtensionVersion = "1.5.1"
val javaVersion = JavaVersion.VERSION_17

const val packageName = "ru.mobile.nzarubin"

object BuildPlugins {
    const val androidLibrary = "com.android.library"
    const val androidApplicationPlugin = "com.android.application"
}
