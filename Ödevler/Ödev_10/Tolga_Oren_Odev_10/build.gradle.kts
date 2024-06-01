// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
}

buildscript {
    dependencies {
        classpath (libs.google.services)
        classpath (libs.androidx.navigation.safe.args.gradle.plugin)
    }
}