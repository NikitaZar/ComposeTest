plugins {
    id(BuildPlugins.androidLibrary)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "$packageName.utils"
    commonAndroid()
}

dependencies {
    implementation(libs.androidx.core.ktx)
}