import org.gradle.api.JavaVersion

const val packageName = "ru.mobile.nzarubin"

object AndroidSdk {
    const val minSdk = 23
    const val compileSdk = 34
    const val targetSdk = compileSdk
}

object BuildVersions {
    val javaVersion = JavaVersion.VERSION_1_8
    const val jvmTarget = "1.8"
}

object BuildPlugins {
    object Versions {
        const val ktlintVersion = "0.44.0"
    }

    const val ktlint = "com.pinterest:ktlint:${Versions.ktlintVersion}"
}
