plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.4.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
}

