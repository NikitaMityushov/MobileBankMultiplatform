plugins {
    id("bank.library-android-compose")
}

android {
    namespace = "com.mityushovn.mobilebankmultiplatform.android.ui"
}

dependencies {
    implementation(libs.bundles.compose.theme)
}