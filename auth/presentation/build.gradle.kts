plugins {
    alias(libs.plugins.runtracker.android.feature.ui)
}

android {
    namespace = "dev.abhinav.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}