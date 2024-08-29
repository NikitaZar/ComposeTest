// Top-level build file where you can add configuration options common to all sub-projects/modules.
//buildscript {
//    dependencies {
//        classpath(libs.hilt.android.gradle.plugin)
//    }
//}

plugins {
    id(BuildPlugins.androidApplicationPlugin) apply false
    id(BuildPlugins.androidLibrary) apply false

    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
}