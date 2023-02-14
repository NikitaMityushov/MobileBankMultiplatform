import common.KotlinConfig
import gradle.kotlin.dsl.accessors._43eb709616901b6142395cb7066fc79f.kotlinOptions

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = ApkConfig.NAMESPACE
    compileSdk = ApkConfig.COMPILE_SDK_VERSION
    defaultConfig {
        applicationId = ApkConfig.APPLICATION_ID
        minSdk = ApkConfig.MIN_SDK_VERSION
        targetSdk = ApkConfig.TARGET_SDK_VERSION
        versionCode = ApkConfig.VERSION_CODE
        versionName = ApkConfig.VERSION_NAME
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

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        maybeCreate("debug").apply {
            multiDexEnabled = true
            isDebuggable = true
        }

        maybeCreate("release").apply {
            isShrinkResources = true
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
