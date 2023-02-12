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
        kotlinCompilerExtensionVersion = "1.3.0"
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
