plugins {
    id("bank.multi-decompose")
    id("bank.library-android")
}

kotlin {
    sourceSets {
        val androidMain by getting {
            dependencies {
                with(libs) {
                    implementation(ktor.client.okhttp)
                    implementation(compose.viewmodel)
                    implementation(kotlin.coroutines.android)
                }
            }
        }
        val commonMain by getting {
            dependencies {
                with(libs) {
                    implementation(decompose.decompose)
                    implementation(ktor.client.core)
                    implementation(ktor.client.logging)
                    implementation(ktor.client.negotiation)
                    implementation(ktor.client.kotlinx.serialization)
                    implementation(kotlin.coroutines.core)
                    implementation(kodein)
                    implementation(settings)
                    implementation(arrow.core)
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.kotlin.coroutines.test)
                implementation(libs.mockk.mockk)
            }
        }
    }
}

android {
    namespace = "com.mityushovn.mobilebankmultiplatform.shared.auth"
}
