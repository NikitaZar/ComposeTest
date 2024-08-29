plugins {
    id(BuildPlugins.androidLibrary)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "$packageName.presentation"
    commonAndroid()
    kotlinOptions {
        jvmTarget = BuildVersions.jvmTarget
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":designSystem"))
    implementation(project(":domain"))
    implementation(project(":utils"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.runtime)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}