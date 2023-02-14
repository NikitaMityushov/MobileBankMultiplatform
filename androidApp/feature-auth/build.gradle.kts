plugins {
    id("bank.library-android-compose")
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
        implementation(compose.viewmodel)
        implementation(platform(compose.bom))
        implementation(androidx.fragment.ktx)
    }

    implementation(project(":androidApp:ui"))
    implementation(project(":shared:auth"))
}