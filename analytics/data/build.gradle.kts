plugins {
    alias(libs.plugins.runtracker.android.library)
}

android {
    namespace = "dev.abhinav.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(projects.analytics.domain)
}