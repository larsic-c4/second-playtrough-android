plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "rs.ac.bg.etf.pmu.al200730d.secondplaytrough"
    compileSdk = 34

    defaultConfig {
        applicationId = "rs.ac.bg.etf.pmu.al200730d.secondplaytrough"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    val room_version = "2.5.2"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.camera:camera-camera2:1.2.3")
    implementation("androidx.camera:camera-lifecycle:1.2.3")
    implementation("androidx.camera:camera-view:1.3.0-rc01")
    implementation("androidx.camera:camera-extensions:1.3.0-rc01")

    val lifecycle_version = "2.6.1"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Lifecycle utilities for Compose
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")
    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
    constraints{
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0")
    }
    // Java language implementation
    implementation("androidx.navigation:navigation-fragment:2.7.1")
    implementation("androidx.navigation:navigation-ui:2.7.1")

    implementation ("com.google.dagger:hilt-android:2.48")
    annotationProcessor("com.google.dagger:hilt-compiler:2.48")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    annotationProcessor("androidx.hilt:hilt-compiler:1.1.0-alpha01")


}