plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android-extensions")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles("proguard-rules.pro")
                consumerProguardFiles("proguard-rules.pro")
            }
        }
    }
}

androidExtensions { isExperimental = true }

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.50")
    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.3.0"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.12.0")
    implementation("org.jetbrains.kotlin:kotlin-android-extensions-runtime:1.3.50")
    implementation("androidx.appcompat:appcompat:1.1.0-rc01")
    implementation("com.squareup.okhttp3:okhttp:4.1.1")
    testImplementation("junit:junit:4.12")
}