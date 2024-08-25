plugins {
    `kotlin-dsl`
}
repositories {
    google()
    mavenCentral()
}
dependencies {
    val agp = "8.5.2"
    implementation("com.android.tools.build:gradle:$agp")
    val androidPluginId = "com.android.application"
    implementation("${androidPluginId}:${androidPluginId}.gradle.plugin:$agp")
}