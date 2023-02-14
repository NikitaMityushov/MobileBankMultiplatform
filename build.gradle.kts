plugins {

    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<Test>().configureEach {
    if (!project.hasProperty("createReports")) {
        reports.html.required.set(false)
        reports.junitXml.required.set(false)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.isFork = true
}
