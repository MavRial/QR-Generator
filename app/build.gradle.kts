plugins {
    alias(libs.plugins.android.application) // Android App
    alias(libs.plugins.kotlin.android)      // Kotlin Android
    alias(libs.plugins.kotlin.compose)      // Jetpack Compose
    alias(libs.plugins.hilt.android)        // Hilt DI
    kotlin("kapt")                          // Annotation Processor
}

android {
    namespace = "com.example.qrgenerator"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.qrgenerator"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // === CORE / KOTLIN ===
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // === JETPACK COMPOSE ===
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    // === MATERIAL DESIGN ===
    implementation(libs.androidx.material3)

    // === NAVIGATION COMPOSE ===
    implementation(libs.androidx.navigation.compose)

    // === COROUTINES ===
    implementation(libs.kotlinx.coroutines.android)

    // === HILT / DI ===
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.navigation.compose)

    // === TESTING ===
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // === DEBUG / TOOLING ===
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // === MOCKING ===
    testImplementation(libs.mockk)
}