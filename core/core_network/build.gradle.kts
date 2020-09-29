plugins {
    id(Plugins.ANDROID_LIB_PLUGIN_WITH_DEFAULT_CONFIG)
//    id("api-generator-android")
}

// TODO: uncomment api generator
//apiGenerator {
//    pathToApiSchemes = "${AndroidConfig.COMMON_FOLDER}/api"
//    outputPackageName = AndroidConfig.TEST_APP_ID
//    outputLanguage = apigen.OutputLanguage.KotlinAndroid(
//            methodOutputType = apigen.MethodOutputType.Coroutine
//    )
//}

dependencies {
    retrofit()
    dagger()
    moshi()
    coroutines()
}
