plugins {
    id(BuildPlugins.androidLibrary)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "$packageName.utils"
    commonAndroid()
    kotlinOptions {
        jvmTarget = BuildVersions.jvmTarget
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.runtime)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.lifecycle)
}