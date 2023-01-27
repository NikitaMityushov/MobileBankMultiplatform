plugins {
    id("com.android.library")
}

android {
    namespace = ApkConfig.NAMESPACE
    compileSdk = ApkConfig.COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = ApkConfig.MIN_SDK_VERSION
        targetSdk = ApkConfig.TARGET_SDK_VERSION
    }
}