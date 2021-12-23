import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version Dependencies.kotlinVersion
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("io.ktor:ktor-client-core:${Dependencies.ktorVersion}")
    implementation("io.ktor:ktor-client-cio:${Dependencies.ktorVersion}")
    implementation("io.ktor:ktor-client-serialization:${Dependencies.ktorVersion}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}