plugins {
    id("bank.app-android")
}

android {
    namespace = "com.mityushovn.mobilebankmultiplatform.android.app"
}

dependencies {
    with(libs) {
        implementation(compose.ui.ui)
        implementation(compose.ui.preview)
        implementation(compose.ui.tooling)
        implementation(compose.foundation.foundation)
        implementation(compose.material.material)
        implementation(compose.activity)
        implementation(androidx.fragment.ktx)
        implementation(androidx.navigation.fragment.ktx)
        implementation(androidx.navigation.ui.ktx)
        implementation(androidx.appcompat.appcompat)
    }

    implementation(project(":shared:sample"))
    implementation(project(":androidApp:ui"))

    // features
    implementation(project(":androidApp:feature-auth"))
}