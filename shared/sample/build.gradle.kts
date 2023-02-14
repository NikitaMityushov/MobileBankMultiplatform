plugins {
    id("bank.multi-library")
    id("bank.library-android")
}

kotlin {
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.mityushovn.mobilebankmultiplatform.shared.sample"
}
