// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.androidApplicationPlugin) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id(BuildPlugins.androidLibrary) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.compose.compiler) apply false
}