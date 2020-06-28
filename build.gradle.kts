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
        classpath("com.google.firebase:firebase-crashlytics-gradle:${Version.FIREBASE_CRASHLYTICS}")
        classpath("com.vanniktech:gradle-dependency-graph-generator-plugin:0.5.0")
    }
}

plugins {
    id(Plugins.DETEKT).version("1.10.0")
    id(Plugins.CPD).version("3.1")
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

//TODO: make staticAnalysis work on kotlin DSL
//apply(from = "$buildScriptsDir/gradle/staticAnalysis.gradle")
