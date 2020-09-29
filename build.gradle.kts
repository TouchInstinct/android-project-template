buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Version.ANDROID_PLUGIN}")
        classpath(kotlin("gradle-plugin", version = Version.KOTLIN))
        classpath("com.google.gms:google-services:${Version.GOOGLE_SERVICES_PLUGIN}")
        classpath("com.google.firebase:firebase-crashlytics-gradle:${Version.FIREBASE_CRASH_PLUGIN}")
        classpath("com.vanniktech:gradle-dependency-graph-generator-plugin:0.5.0")
        classpath("com.google.android.gms:oss-licenses-plugin:0.10.2")
    }
}

plugins {
    id(Plugins.DEPENDENCY_GRAPH).version("0.5.0")
    id("static-analysis-android")
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("http://dl.bintray.com/touchin/touchin-tools")
        maven("https://jitpack.io")
    }
}

subprojects {
    apply(plugin = Plugins.DETEKT)
}

val buildScriptsDir = "${rootProject.projectDir}/BuildScripts"
ext["buildScriptsDir"] = buildScriptsDir

apply(plugin = Plugins.DEPENDENCY_GRAPH)

staticAnalysis {
    buildScriptDir = buildScriptsDir
}
