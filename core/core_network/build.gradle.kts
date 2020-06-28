plugins {
    id(Plugins.ANDROID_LIB_PLUGIN_WITH_DEFAULT_CONFIG)
}

val customEndpoint: String? = System.getenv("CUSTOM_ENDPOINT")?.takeIf(String::isNotBlank)

android {
    defaultConfig {
        rootProject.extensions.add("pathToApiSchemes", "$rootDir/common/api")
        rootProject.extensions.add("applicationId", AndroidConfig.TEST_APP_ID)
    }

    flavorDimensions(
            ApiFlavour.DIMENSION_NAME,
            SSLPinningFlavour.DIMENSION_NAME,
            TestPanelFlavour.DIMENSION_NAME
    )

    addFlavour(ApiFlavour.MockDev, customEndpoint)
    addFlavour(ApiFlavour.TouchinTest, customEndpoint)
    addFlavour(ApiFlavour.CustomerProd, customEndpoint)

    addFlavour(SSLPinningFlavour.OFF)
    addFlavour(SSLPinningFlavour.ON)

    productFlavors {
        addEmptyFlavour(TestPanelFlavour.OFF)
        addEmptyFlavour(TestPanelFlavour.ON)
    }
}

dependencies {
    retrofit()
    dagger()
    moshi()
    coroutines()
    chucker()
}

//afterEvaluate {
//    tasks
//            .asIterable()
//            .filter { it.name.contains("compile") && it.name.contains("JavaWithJavac") }
//            .forEach { it.dependsOn("apiGenerator") }
//}
//
//apply(from = "${rootProject.extra["buildScriptsDir"]}/gradle/apiGenerator.gradle")
