pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        versionCatalogs {
            create("libs") {
                val composeVersion = "1.2.1"
                library("compose-ui-ui", "androidx.compose.ui:ui:$composeVersion")
                library("compose-ui-tooling", "androidx.compose.ui:ui-tooling:$composeVersion")
                library("compose-ui-preview", "androidx.compose.ui:ui-tooling-preview:$composeVersion")
                library("compose-foundation-foundation", "androidx.compose.foundation:foundation:$composeVersion")
                library("compose-material-material", "androidx.compose.material:material:$composeVersion")
                val composeActivityVersion = "1.5.1"
                library("compose-activity", "androidx.activity:activity-compose:$composeActivityVersion")
                val agpVersion = "7.3.1"
                library("agp", "com.android.tools.build:gradle:$agpVersion")
                val kotlinGP = "1.7.10"
                library("kotlinGP", "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinGP")
            }
        }

    }
}

rootProject.name = "MobileBankMultiplatform"
// shared
include(":androidApp")
include(":androidApp:app")
include(":shared")
// core
include(":core")
include(":core:ui")
// features
include(":features")
