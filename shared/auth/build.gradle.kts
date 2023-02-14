plugins {
    id("bank.multi-decompose")
    id("bank.library-android")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.decompose.decompose)
                implementation(libs.ktor.client.core)
                implementation(libs.kotlin.coroutines.core)
                implementation(libs.kodein)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.mityushovn.mobilebankmultiplatform.shared.auth"
}
