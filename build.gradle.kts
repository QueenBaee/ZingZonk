// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
    google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.7.1") // Pastikan versi sesuai dengan Android Studio yang digunakan
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0") // Versi Kotlin yang sesuai
    }
}

allprojects {
    repositories {
    }
}
