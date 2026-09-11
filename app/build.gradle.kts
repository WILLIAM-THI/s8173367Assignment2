plugins {
    alias(libs.plugins.android.application)
    id("org.jetbrains.kotlin.plugin.parcelize") version "2.3.0"
    id("androidx.navigation.safeargs.kotlin") version "2.10.0"
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android") version "2.60.1"
}

android {
    namespace = "com.example.s8173367assignment2"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.s8173367assignment2"
        minSdk = 27
        targetSdk = 37
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    //implementation(libs.androidx.fragment.ktx)
    //implementation(libs.androidx.lifecycle.livedata.ktx)
    //implementation(libs.androidx.lifecycle.viewmodel.ktx)
    //implementation(libs.androidx.navigation.fragment.ktx)
    //implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.material)
    //implementation(libs.androidx.navigation.fragment)
    //implementation(libs.androidx.navigation.ui)

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    // Coroutine dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.11.0")

    // Retrofit dependencies
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-moshi:3.0.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.5.0")

    // Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.60.1")
    ksp("com.google.dagger:hilt-android-compiler:2.60.1")

    // Local unit test dependencies (run on the JVM)
    testImplementation("io.mockk:mockk:1.14.11") // Core MockK library for local unit tests
    testImplementation("io.mockk:mockk-android:1.14.11") // Android-specific MockK for local unit tests
    testImplementation("io.mockk:mockk-agent:1.14.11") // MockK agent for advanced mocking (e.g., static methods)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.11.0")

    // Android-specific MockK for instrumented tests
    androidTestImplementation("io.mockk:mockk-agent:1.14.11") // MockK agent for advanced mocking in instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.3") // AndroidX JUnit for instrumented tests
    androidTestImplementation("io.mockk:mockk-android:1.14.11")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}