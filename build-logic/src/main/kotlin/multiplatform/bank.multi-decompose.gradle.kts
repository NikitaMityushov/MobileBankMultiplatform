import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

configure<KotlinMultiplatformExtension> {
    android()
}
