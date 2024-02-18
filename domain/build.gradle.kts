plugins {
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
}

dependencies {
    implementation("io.ktor:ktor-client-serialization-jvm:2.3.8")
}
