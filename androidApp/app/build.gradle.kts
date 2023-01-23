plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.mityushovn.mobilebankmultiplatform.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.mityushovn.mobilebankmultiplatform.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
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
        getByName("release") {
            isMinifyEnabled = false
        }
    }

}

dependencies {
    with(libs) {
        implementation(compose.ui.ui)
        implementation(compose.ui.preview)
        implementation(compose.ui.tooling)
        implementation(compose.foundation.foundation)
        implementation(compose.material.material)
        implementation(compose.activity)
    }
    implementation(project(":shared"))
}