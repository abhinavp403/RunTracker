plugins {
    alias(libs.plugins.runtracker.android.library)
}

android {
    namespace = "dev.abhinav.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}