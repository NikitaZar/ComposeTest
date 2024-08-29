plugins {
    id(BuildPlugins.androidLibrary)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "$packageName.domain"
    commonAndroid()
    kotlinOptions {
        jvmTarget = BuildVersions.jvmTarget
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}