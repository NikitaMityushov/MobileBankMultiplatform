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

            }
        }

    }
}

rootProject.name = "MobileBankMultiplatform"
include(":androidApp")
include(":androidApp:app")
include(":shared")