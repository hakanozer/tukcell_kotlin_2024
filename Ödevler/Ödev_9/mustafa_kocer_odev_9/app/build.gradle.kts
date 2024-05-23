plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.odev9"
    compileSdk = 34


    viewBinding{
        enable = true
    }

    defaultConfig {
        applicationId = "com.example.odev9"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
    implementation(libs.retrofit)
// https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation(libs.okhttp)
// https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson
    implementation(libs.converter.gson)
    implementation(libs.glide)
    val paging_version = "3.3.0"

    implementation("androidx.paging:paging-runtime:$paging_version")

    implementation("androidx.paging:paging-common:$paging_version")
}