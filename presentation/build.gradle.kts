plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kapt)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "$packageName.presentation"
        compileSdk = AndroidSdk.compileSdk

    defaultConfig {
        minSdk = AndroidSdk.minSdk
    }

    compileOptions {
        sourceCompatibility = BuildVersions.javaVersion
        targetCompatibility = BuildVersions.javaVersion
    }
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
    kapt(libs.hilt.compiler)
}