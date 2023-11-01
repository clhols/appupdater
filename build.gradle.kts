plugins {
    id("com.android.library")
    kotlin("android")
    id("org.jetbrains.compose")
    id("kotlin-parcelize")
    id("kotlinx-serialization")
    id("maven-publish")
}

compose {
    kotlinCompilerPlugin.set(Versions.composeCompiler)
}

android {
    namespace = "dk.youtec.appupdater"
    compileSdk = Versions.compileSdk
    buildToolsVersion = Versions.buildTools

    buildFeatures {
        // Disable unused AGP features
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles("proguard-rules.pro")
                consumerProguardFiles("proguard-rules.pro")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:${Versions.coroutines}"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("com.squareup.okhttp3:okhttp:${Versions.okhttp}")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

afterEvaluate {
    publishing {
        publications {
            create("appupdaterLib", MavenPublication::class.java) {
                groupId = "dk.youtec"
                artifactId = "appupdater-lib"
                version = "1.0.0"

                artifact("$buildDir/outputs/aar/appupdater-release.aar")
            }
        }
    }
}