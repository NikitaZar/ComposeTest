val ktlint: Configuration by configurations.creating

buildscript {
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
}

dependencies {
    ktlint(BuildPlugins.ktlint) {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
}

allprojects {
    val ktlintCheck by tasks.creating(JavaExec::class) {
        inputs.files(project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt")))
        outputs.dir("${project.buildDir}/reports/ktlint/")

        group = "verification"
        description = "Check Kotlin code style."
        classpath = ktlint
        mainClass.set("com.pinterest.ktlint.Main")
        args = listOf("src/**/*.kt")
    }

    val ktlintFormat by tasks.creating(JavaExec::class) {
        inputs.files(project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt")))
        outputs.dir("${project.buildDir}/reports/ktlint/")

        group = "verification"
        description = "Fix Kotlin code style deviations."
        classpath = ktlint
        mainClass.set("com.pinterest.ktlint.Main")
        args = listOf("-F", "src/**/*.kt")
        jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
    }
}
