plugins {
    id(Plugins.ANDROID_APP_PLUGIN_WITH_DEFAULT_CONFIG)
    id(Plugins.FIREBASE_CRASH)
    id(Plugins.GOOGLE_SERVICES)
    id(Plugins.LICENCE_PLUGIN)
}

val customEndpoint: String? = Environment.ENDPOINT.getenv()?.takeIf(String::isNotBlank)

android {
    configureSigningConfig(this@Build_gradle::file)

    with(defaultConfig) {
        applicationId = Environment.APP_ID.getenv() ?: AndroidConfig.TEST_APP_ID
        signingConfig = signingConfigs.getByName(SigningConfig.CONFIG_NAME)
    }

    firebaseCrashlytics {
        mappingFileUploadEnabled = true
    }

    addBuildType(BuildType.Debug, buildScriptDir = buildScriptDir)
    addBuildType(BuildType.Release, buildScriptDir = buildScriptDir)

    flavorDimensions(
            ApiFlavour.DIMENSION_NAME,
            SSLPinningFlavour.DIMENSION_NAME,
            TestPanelFlavour.DIMENSION_NAME
    )

    addFlavour(flavour = ApiFlavour.CustomerStage, customEndpoint = customEndpoint)
    addFlavour(flavour = ApiFlavour.CustomerProd, customEndpoint = customEndpoint)

    addFlavour(SSLPinningFlavour.OFF)
    addFlavour(SSLPinningFlavour.ON)

    addEmptyFlavour(TestPanelFlavour.OFF)
    addEmptyFlavour(TestPanelFlavour.ON)

    ignoreCustomerProdFlavourIfReleaseIsDebuggable()
}

androidExtensions {
    features = setOf("parcelize")
}

dependencies {
    androidX()
    featureModules()
    mvi()
    materialDesign()
    dagger()
    retrofit()
    moshi()
    navigation()
    leakCanary()
    sharedPrefs()
    chucker()
    implementation(Library.FIREBASE_ANAL)
    implementation(Library.FIREBASE_CRASH)
    implementation(Library.FIREBASE_PERF)
    implementation(Library.ANDROIDX_SECURE)
    coreNetwork()
    coreStrings()
    implementationModule(Module.Core.UI)
    implementationModule(Module.Core.UTILS)
    implementationModule(Module.Core.DATA)
    implementationModule(Module.RoboSwag.UTILS)
}

apply(from = "$buildScriptDir/gradle/scripts/applicationFileNaming.gradle")

val Project.buildScriptDir: String
    get() = rootProject.ext["buildScriptsDir"] as String
