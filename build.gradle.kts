plugins {
    java
    kotlin("multiplatform") version Dependencies.kotlinVersion
}

allprojects {
    plugins.apply("java")

    group = "project"
    version = "0.1"

    repositories {
        mavenCentral()
    }
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}