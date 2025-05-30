plugins {
    alias(libs.plugins.runtracker.android.library)
    alias(libs.plugins.runtracker.jvm.ktor)
}

android {
    namespace = "dev.abhinav.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(libs.bundles.koin)
}