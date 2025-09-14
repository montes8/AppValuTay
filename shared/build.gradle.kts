import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("app.cash.sqldelight") version "2.1.0"
    kotlin("plugin.serialization") version "2.2.0"

}

repositories {
    google()
    mavenCentral()
}


kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    val ktorVersion = "3.1.1"
    val kotlinxDatetime = "0.6.1"
    val sqlDelightVersion = "2.1.0"
    sourceSets {
         androidMain.dependencies {
                implementation("app.cash.sqldelight:android-driver:2.1.0")
                implementation("io.ktor:ktor-client-okhttp:${ktorVersion}")
            }

        commonMain.dependencies {
            api(libs.koin.core)
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.1.0")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
            implementation("io.ktor:ktor-client-logging:${ktorVersion}")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:${kotlinxDatetime}")
            implementation("app.cash.sqldelight:runtime:2.1.0")

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

         iosMain.dependencies {
                implementation("app.cash.sqldelight:native-driver:${sqlDelightVersion}")
                implementation("io.ktor:ktor-client-darwin:${ktorVersion}")

            }
    }
}

android {
    namespace = "com.tayler.appvalutay.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

sqldelight {
    databases {
        create("AppValuTayDb") {
            packageName.set("com.tayler.appvalutay.database")
        }
    }
}