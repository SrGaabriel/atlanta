plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.4.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))

    api("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.9")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.3.9")
}

