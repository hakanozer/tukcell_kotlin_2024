plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.navigationSafeArgs)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.hiltAndroid)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.selincengiz.selin_cengiz_vize3"
    compileSdk = 34

    dataBinding{
        enable=true
    }

    defaultConfig {
        applicationId = "com.selincengiz.selin_cengiz_vize3"
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

    // SSP-SDP library
    implementation (libs.ssp.android)
    implementation (libs.sdp.android)

    // Navigation
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation( libs.androidx.navigation.ui.ktx)

    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    //Glide
    implementation (libs.glide)

    //Roundable Layout
    implementation (libs.roundableLayout)

    //Lottie
    implementation (libs.lottie)

    //Hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)

    //Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
}