plugins {
    id("com.android.library")
    kotlin("android")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.example.data"

    compileSdk = 33

    defaultConfig {
        minSdk = 24
        testOptions.targetSdk = 33
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Добавляем зависимость от модуля domain
    implementation(project(":domain"))

    implementation("io.ktor:ktor-client-android:1.6.7")
    implementation("io.ktor:ktor-client-serialization-jvm:1.6.7")
    implementation("io.ktor:ktor-client-logging-jvm:1.6.7")

    implementation("com.google.dagger:hilt-android:2.50")
    ksp("com.google.dagger:hilt-compiler:2.50")
}
