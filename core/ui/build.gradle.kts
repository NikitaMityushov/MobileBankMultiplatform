plugins {
    `library-android`
}

android {
    namespace = "com.mityushovn.mobilebankmultiplatform.android.ui"
}

dependencies {
    with(libs) {
        implementation(compose.ui.ui)
        implementation(compose.foundation.foundation)
        implementation(compose.material.material)
    }
}