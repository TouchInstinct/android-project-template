plugins {
    id(Plugins.ANDROID_LIB_PLUGIN_WITH_DEFAULT_CONFIG)
}


android {
    defaultConfig {
        rootProject.extensions.add("pathToApiSchemes", "$rootDir/common/api")
        rootProject.extensions.add("applicationId", AndroidConfig.TEST_APP_ID)
    }
}

dependencies {
    retrofit()
    dagger()
    moshi()
    coroutines()
}

//afterEvaluate {
//    tasks
//            .asIterable()
//            .filter { it.name.contains("compile") && it.name.contains("JavaWithJavac") }
//            .forEach { it.dependsOn("apiGenerator") }
//}
//
//apply(from = "${rootProject.extra["buildScriptsDir"]}/gradle/apiGenerator.gradle")
