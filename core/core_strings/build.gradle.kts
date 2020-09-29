plugins {
    id(Plugins.ANDROID_LIB_PLUGIN_WITH_DEFAULT_CONFIG)
}
android {
    ext["languageMap"] = mapOf("ru" to "${AndroidConfig.COMMON_FOLDER}/strings/default_common_strings_ru.json")
    ext["rootPath"] = "core/core_strings"
}

//gradle.projectsEvaluated {
//    tasks.named("preBuild") {
//        dependsOn("stringGenerator")
//    }
//}
//
//apply(from = "${rootProject.ext["buildScriptsDir"]}/gradle/stringGenerator.gradle")
