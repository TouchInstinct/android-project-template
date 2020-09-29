package plugins

import AndroidConfig
import BuildType
import Plugins
import com.android.build.gradle.BaseExtension
import kotlinStd
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

abstract class BaseAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configurePlugins()
        target.configureAndroid()
        target.configureDependencies()
    }

    private fun Project.configurePlugins() {
        plugins.apply(Plugins.KOTLIN_ANDROID)
        plugins.apply(Plugins.KOTLIN_ANDROID_EXTENSIONS)
        plugins.apply(Plugins.KOTLIN_KAPT)
    }

    private fun Project.configureAndroid() = extensions.getByType<BaseExtension>().run {
        compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
        buildToolsVersion = AndroidConfig.BUILD_TOOLS_VERSION

        defaultConfig {
            minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
            targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
            versionCode = AndroidConfig.VERSION_CODE
            versionName = AndroidConfig.VERSION_NAME
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
            coreLibraryDesugaringEnabled = true
        }

        buildFeatures.viewBinding = true

        tasks.withType(KotlinCompile::class.java) {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }

        if (AndroidConfig.RELEASE_DEBUGGABLE) {
            buildTypes {
                getByName(BuildType.Release.name) {
                    isDebuggable = true
                }
            }
        }
    }

    private fun Project.configureDependencies() = dependencies {
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        kotlinStd()
        add("coreLibraryDesugaring", "com.android.tools:desugar_jdk_libs:1.0.5")
    }

    private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
            add("implementation", dependencyNotation)
}
