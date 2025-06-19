plugins {
    alias(libs.plugins.runtracker.android.feature.ui)
}

android {
    namespace = "dev.abhinav.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}