import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.fragment() {
    implementation(Library.ANDROIDX_FRAGMENT)
    implementation(Library.ANDROIDX_FRAGMENT_KTX)
    implementationModule(Module.RoboSwag.NAVIGATION_BASE)
}

fun DependencyHandler.materialDesign() {
    implementation(Library.ANDROID_MATERIAL)
    implementation(Library.SWIPE_REFRESH)
}

fun DependencyHandler.constraintLayout() {
    implementation(Library.ANDROIDX_CONSTRAINT)
}

fun DependencyHandler.androidX() {
    implementation(Library.ANDROIDX_CORE)
    implementation(Library.ANDROIDX_APPCOMPAT)
    implementationModule(Module.RoboSwag.KOTLIN_EXTENSIONS)
}

fun DependencyHandler.recyclerView() {
    implementation(Library.ANDROIDX_RECYCLER)
    implementationModule(Module.RoboSwag.RECYCLER_VIEW_ADAPTERS)
}

fun DependencyHandler.kotlinStd() {
    implementation(Library.KOTLIN_STDLIB)
}

fun DependencyHandler.navigation() {
    implementation(Library.CICERONE)
    implementationModule(Module.RoboSwag.NAVIGATION_CICERONE)
}

fun DependencyHandler.featureModules() {
    Module.Feature.ALL.forEach(this::implementationModule)
}

fun DependencyHandler.mvi() {
    implementationModule(Module.RoboSwag.MVI_ARCH)
    fragment()
    lifecycle()
}

fun DependencyHandler.coreNetwork() {
    implementationModule(Module.Core.NETWORK)
}

fun DependencyHandler.retrofit() {
    implementation(Library.RETROFIT)
    implementation(Library.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Library.OKHTTP)
    implementation(Library.MOSHI_RETROFIT)
}

fun DependencyHandler.dagger(withAssistedInject: Boolean = true) {
    implementation(Library.DAGGER)
    kapt(Library.DAGGER_COMPILER)
    implementation(Library.DAGGER_COMPONENT_MANAGER)

    if (withAssistedInject) {
        compileOnly(Library.DAGGER_INJECT_ASSISTED_ANNOTATIONS)
        kapt(Library.DAGGER_INJECT_ASSISTED_PROCESSOR)
    }
}

fun DependencyHandler.glide() {
    implementation(Library.GLIDE)
    implementation(Library.GLIDE_OKHTTP_INTEGRATION)
    kapt(Library.GLIDE_COMPILER)
}

fun DependencyHandler.moshi() {
    implementation(Library.MOSHI)
    kapt(Library.MOSHI_CODEGEN)
}

fun DependencyHandler.lifecycle() {
    implementation(Library.ANDROID_LIFECYCLE_EXTENSIONS)
    implementation(Library.ANDROID_LIFECYCLE_VIEW_MODEL_EXTENSIONS)
    implementation(Library.ANDROID_LIFECYCLE_LIVE_DATA_EXTENSIONS)
    implementationModule(Module.RoboSwag.LIFECYCLE)
}

fun DependencyHandler.coroutines() {
    implementation(Library.COROUTINES_CORE)
    implementation(Library.COROUTINES_ANDROID)
}

fun DependencyHandler.leakCanary() {
    add("withTestPanelImplementation", Library.LEAK_CANARY)
}

fun DependencyHandler.sharedPrefs() {
    implementationModule(Module.RoboSwag.STORABLE)
    implementationModule(Module.Core.PREFS)
}

fun DependencyHandler.chucker() {
    add("withTestPanelImplementation", Library.CHUCKER)
    add("withoutTestPanelImplementation", Library.CHUCKER_NO_OP)
}

fun DependencyHandler.implementationModule(moduleName: String) {
    implementation(project(":$moduleName"))
}

private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
        add("implementation", dependencyNotation)

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
        add("kapt", dependencyNotation)

private fun DependencyHandler.compileOnly(dependencyNotation: Any): Dependency? =
        add("compileOnly", dependencyNotation)

private fun DependencyHandler.project(
        path: String,
        configuration: String? = null
): ProjectDependency {
    val notation = if (configuration != null) {
        mapOf("path" to path, "configuration" to configuration)
    } else {
        mapOf("path" to path)
    }

    return uncheckedCast(project(notation))
}

@Suppress("unchecked_cast", "nothing_to_inline", "detekt.UnsafeCast")
private inline fun <T> uncheckedCast(obj: Any?): T = obj as T
