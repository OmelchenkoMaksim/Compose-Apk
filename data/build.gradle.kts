plugins {
    id("com.android.library")
    kotlin("android")
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
}

dependencies {
    // Добавляем зависимость от модуля domain
    implementation(project(":domain"))

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    // Для использования Kotlin coroutines с Room
    implementation("androidx.room:room-ktx:2.6.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
}
