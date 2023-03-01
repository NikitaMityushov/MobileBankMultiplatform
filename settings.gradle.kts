pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
            create("libs") {
                val composeVersion = "1.2.1"
                library("compose-ui-ui", "androidx.compose.ui:ui:$composeVersion")
                library("compose-ui-tooling", "androidx.compose.ui:ui-tooling:$composeVersion")
                library("compose-ui-preview", "androidx.compose.ui:ui-tooling-preview:$composeVersion")
                library("compose-foundation-foundation", "androidx.compose.foundation:foundation:$composeVersion")
                library("compose-material-material", "androidx.compose.material:material:$composeVersion")
                bundle("compose-theme", listOf("compose-ui-ui", "compose-foundation-foundation", "compose-material-material"))

                val composeBomVersion = "2023.01.00"
                library("compose-bom", "androidx.compose:compose-bom:$composeBomVersion")

                val composeActivityVersion = "1.5.1"
                library("compose-activity", "androidx.activity:activity-compose:$composeActivityVersion")

                val composeViewModelVersion = "2.5.1"
                library("compose-viewmodel", "androidx.lifecycle:lifecycle-viewmodel-compose:$composeViewModelVersion")

                val fragmentVersion = "1.5.5"
                library("androidx-fragment-ktx", "androidx.fragment:fragment-ktx:$fragmentVersion")
                library("androidx-fragment-debug", "androidx.fragment:fragment-testing:$fragmentVersion")

                val appCompatVersion = "1.6.1"
                library("androidx-appcompat-appcompat", "androidx.appcompat:appcompat:$appCompatVersion")

                val decomposeVersion = "1.0.0"
                library("decompose-decompose", "com.arkivanov.decompose:decompose:$decomposeVersion")
                library("decompose-compose-jetpack","com.arkivanov.decompose:extensions-compose-jetpack:$decomposeVersion")

                val ktorVersion = "2.2.3"
                library("ktor-client-core", "io.ktor:ktor-client-core:$ktorVersion")
                library("ktor-client-negotiation", "io.ktor:ktor-client-content-negotiation:$ktorVersion")
                library("ktor-client-kotlinx-serialization", "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                library("ktor-client-okhttp", "io.ktor:ktor-client-okhttp:$ktorVersion")
                library("ktor-client-logging", "io.ktor:ktor-client-logging:$ktorVersion")
                library("ktor-client-darwin", "io.ktor:ktor-client-darwin:$ktorVersion")

                val sqlDelightVersion = "1.5.4"
                plugin("sqldelight-plugin", "com.squareup.sqldelight:gradle-plugin").version(sqlDelightVersion)
                library("sqldelight-runtime", "com.squareup.sqldelight:runtime:$sqlDelightVersion")
                library("sqldelight-android", "com.squareup.sqldelight:android-driver:$sqlDelightVersion")
                library("sqldelight-native", "com.squareup.sqldelight:native-driver:$sqlDelightVersion")

                val coroutinesVersion = "1.6.4"
                library("kotlin-coroutines-core", "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                library("kotlin-coroutines-android", "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
                library("kotlin-coroutines-test", "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")

                val agpVersion = "7.3.1"
                plugin("agp", "com.android.tools.build:gradle").version(agpVersion)

                val kotlinGP = "1.8.0"
                plugin("kotlinGP", "org.jetbrains.kotlin:kotlin-gradle-plugin").version(kotlinGP)
                plugin("kotlinx-serialization", "org.jetbrains.kotlin.plugin.serialization").version(kotlinGP)

                val kodeinVersion = "7.18.0"
                library("kodein", "org.kodein.di:kodein-di:$kodeinVersion")

                val kinzhalVersion = "0.0.5"
                library("kinzhal-processor","com.daugeldauge.kinzhal:kinzhal-processor:$kinzhalVersion")
                library("kinzhal-annotations","com.daugeldauge.kinzhal:kinzhal-annotations:$kinzhalVersion")

                val navComponentFeature = "2.5.3"
                library("androidx-navigation-fragment-ktx", "androidx.navigation:navigation-fragment-ktx:$navComponentFeature")
                library("androidx-navigation-ui-ktx", "androidx.navigation:navigation-ui-ktx:$navComponentFeature")
                library("androidx-navigation-compose", "androidx.navigation:navigation-compose:$navComponentFeature")
                library("androidx-navigation-testing", "androidx.navigation:navigation-testing:$navComponentFeature")

                val settingsVersion = "1.0.0"
                library("settings", "com.russhwolf:multiplatform-settings:$settingsVersion")

                val arrowVersion = "1.1.2"
                library("arrow-core", "io.arrow-kt:arrow-core:$arrowVersion")

                val mockkVersion = "1.13.4"
                library("mockk-mockk", "io.mockk:mockk:$mockkVersion")

        }
    }
}

rootProject.name = "MobileBankMultiplatform"
// builds

// androidApp
include(":androidApp")
include(":androidApp:app")
include(":androidApp:ui")
// shared
include(":shared")
include(":shared:sample")
include(":shared:auth")
include(":androidApp:feature-auth")
