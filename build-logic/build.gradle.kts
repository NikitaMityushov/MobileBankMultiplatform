plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("com.squareup.sqldelight:gradle-plugin:1.5.4")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.8.10")
}
