plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "$packageName.utils"
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.runtime)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.lifecycle)
}