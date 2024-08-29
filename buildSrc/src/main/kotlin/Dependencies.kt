import org.gradle.api.JavaVersion

const val packageName = "ru.mobile.nzarubin"

object AndroidSdk {
    const val minSdk = 23
    const val compileSdk = 34
    const val targetSdk = compileSdk
}

object BuildVersions {
    val javaVersion = JavaVersion.VERSION_1_8
    val jvmTarget = "1.8"
}
