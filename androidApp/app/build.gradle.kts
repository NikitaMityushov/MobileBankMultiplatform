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
        implementation(platform(libs.compose.bom))
    }

    implementation(project(":shared:sample"))
    implementation(project(":androidApp:ui"))

    // features
    implementation(project(":androidApp:feature-auth"))
}