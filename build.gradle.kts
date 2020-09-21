plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android-extensions")
    id("kotlinx-serialization")
    id("maven-publish")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles("proguard-rules.pro")
                consumerProguardFiles("proguard-rules.pro")
            }
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-android-extensions-runtime:1.4.10")
    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.3.9-native-mt"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0-RC2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("com.squareup.okhttp3:okhttp:4.8.1")
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