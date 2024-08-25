plugins {
    id(BuildPlugins.androidLibrary)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "$packageName.data"
    commonAndroid()
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
}