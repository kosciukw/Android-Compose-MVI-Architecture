plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.kotlin.serialization)
  kotlin("kapt") // Add this line for kapt support
  id("dagger.hilt.android.plugin") // Apply Hilt plugin for Gradle
}

android {
  namespace = "pl.kosciukw.petsify"
  compileSdk = libs.versions.compileSdkVersion.get().toInt()

  defaultConfig {
    applicationId = "pl.kosciukw.petsify"
    minSdk = libs.versions.minSdkVersion.get().toInt()
    targetSdk = libs.versions.compileSdkVersion.get().toInt()
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    val javaVersion = libs.versions.javaVersion.get()
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
    targetCompatibility = JavaVersion.toVersion(javaVersion)
  }

  kotlinOptions {
    jvmTarget = libs.versions.javaVersion.get()
  }

  buildFeatures {
    compose = true
  }
}

dependencies {
  implementation(projects.shared.ui)
  implementation(projects.feature.login)
  implementation(projects.feature.signup)
  implementation(projects.feature.main)
  implementation(projects.feature.emaildetails)
  implementation(projects.feature.composer)
  implementation(libs.bundles.androidx)

//  implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//  implementation(libs.androidx.hilt.lifecycle.viewmodel)
  implementation(libs.kotlinx.metadata.jvm)
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
  implementation(libs.androidx.hilt.navigation.compose)

  debugImplementation(libs.bundles.compose.debug)

  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(libs.androidx.ui.test.junit4)

  testImplementation(libs.junit)
}