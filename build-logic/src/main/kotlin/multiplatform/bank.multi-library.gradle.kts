import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
    kotlin("multiplatform")
}

configure<KotlinMultiplatformExtension> {
    android()
}