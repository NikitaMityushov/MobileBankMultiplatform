import common.KotlinConfig
import gradle.kotlin.dsl.accessors._23b0d57d2875d37d80c1f71aa028eae2.android

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = ApkConfig.COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = ApkConfig.MIN_SDK_VERSION
        targetSdk = ApkConfig.TARGET_SDK_VERSION
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = KotlinConfig.KOTLIN_COMPILER_EXTENSION_VERSION

    }

    kotlinOptions {
        jvmTarget = KotlinConfig.JVM_TARGET
    }


}

