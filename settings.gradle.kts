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
                val composeActivityVersion = "1.5.1"
                library("compose-activity", "androidx.activity:activity-compose:$composeActivityVersion")
                val agpVersion = "7.3.1"
                plugin("agp", "com.android.tools.build:gradle").version(agpVersion)
                val kotlinGP = "1.7.10"
                plugin("kotlinGP", "org.jetbrains.kotlin:kotlin-gradle-plugin").version(kotlinGP)
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
