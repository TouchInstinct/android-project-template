plugins {
    id(Plugins.ANDROID_LIB_PLUGIN_WITH_DEFAULT_CONFIG)
}


android {
    defaultConfig {
        rootProject.extensions.add("pathToApiSchemes", "${AndroidConfig.COMMON_FOLDER}/api")
        rootProject.extensions.add("applicationId", AndroidConfig.TEST_APP_ID)
    }
}

dependencies {
    retrofit()
    dagger()
    moshi()
    coroutines()
    //TODO: fix api gen and remove joda
    implementation(Library.JODA)
}

//apply(from = "${rootProject.extra["buildScriptsDir"]}/gradle/apiGenerator.gradle")
