import com.android.build.gradle.BaseExtension
import org.gradle.kotlin.dsl.configure

plugins {
    id("library-android")
}

configure<BaseExtension> {
    buildFeatures.compose = true
}