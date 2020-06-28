import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
    kotlin("jvm") version embeddedKotlinVersion
}

// The kotlin-dsl plugin requires a repository to be declared
repositories {
    jcenter()
    google()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    // android gradle plugin, required by custom plugin
    implementation("com.android.tools.build:gradle:4.0.0")

    // kotlin plugin, required by custom plugin
    implementation(kotlin("gradle-plugin", embeddedKotlinVersion))

    gradleKotlinDsl()
    implementation(kotlin("stdlib-jdk8"))
}


val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
