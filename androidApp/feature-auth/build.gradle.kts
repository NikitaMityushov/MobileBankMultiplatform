plugins {
    id("bank.library-android-compose")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mityushovn.mobilebankmultiplatform.android.feature_auth"
}

dependencies {
    with(libs) {
        implementation(compose.ui.ui)
        implementation(compose.ui.preview)
        implementation(compose.ui.tooling)
        implementation(compose.foundation.foundation)
        implementation(compose.material.material)
        implementation(androidx.fragment.ktx)
        implementation(androidx.navigation.fragment.ktx)
        implementation(androidx.navigation.ui.ktx)
        implementation(compose.viewmodel)
    }

    implementation(project(":androidApp:ui"))
    implementation(project(":shared:auth"))
}