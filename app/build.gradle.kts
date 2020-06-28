plugins {
    id(Plugins.ANDROID_APP_PLUGIN_WITH_DEFAULT_CONFIG)
    id(Plugins.FIREBASE_CRASHLYTICS)
}

android {
    signingConfigs {
        addConfig(SigningConfig.Test)
        addConfig(SigningConfig.Prod)
    }

    defaultConfig {
        applicationId = AndroidConfig.TEST_APP_ID
        signingConfig = signingConfigs.getByName(SigningConfig.Test.name)
    }

    firebaseCrashlytics {
        mappingFileUploadEnabled = true
    }

    buildTypes {
        addBuildType(BuildType.Debug)
        addBuildType(BuildType.Release)
    }

    flavorDimensions(
            ProguardFlavour.DIMENSION_NAME,
            ApiFlavour.DIMENSION_NAME,
            SSLPinningFlavour.DIMENSION_NAME,
            TestPanelFlavour.DIMENSION_NAME
    )

    productFlavors {
        create(ProguardFlavour.NO_OBFUSCATE) {
            dimension = ProguardFlavour.DIMENSION_NAME
            setProguardFiles(listOf(
                    getDefaultProguardFile("proguard-android.txt"),
                    "$rootProject.projectDir/BuildScripts/proguard/noObfuscate.pro"
            ))
        }

        create(ProguardFlavour.OBFUSCATE) {
            dimension = ProguardFlavour.DIMENSION_NAME
            setProguardFiles(listOf(
                    getDefaultProguardFile("proguard-android.txt"),
                    "$rootProject.projectDir/BuildScripts/proguard/obfuscate.pro"
            ))
        }

        addEmptyFlavour(ApiFlavour.MockDev)
        addEmptyFlavour(ApiFlavour.TouchinTest)
        addEmptyFlavour(ApiFlavour.CustomerProd)

        addEmptyFlavour(SSLPinningFlavour.OFF)
        addEmptyFlavour(SSLPinningFlavour.ON)

        addEmptyFlavour(TestPanelFlavour.OFF)
        addEmptyFlavour(TestPanelFlavour.ON)
    }

    extensions.add("languageMap", mapOf("ru" to "Template-common/strings/default_common_strings_ru.json"))

    variantFilter = Action {
        if (name.contentEquals(AndroidConfig.PROD_BUILD_NAME)) {
            (defaultConfig as com.android.build.gradle.internal.dsl.BaseFlavor).apply {
                applicationId = AndroidConfig.PROD_APP_ID
                signingConfig = signingConfigs.getByName(SigningConfig.Prod.name)
            }
        }
    }

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
    coreNetwork()
    leakCanary()
    sharedPrefs()
}

//gradle.projectsEvaluated {
//    preBuild.dependsOn('stringGenerator')
//}

//apply(from = "${rootProject.ext["buildScriptsDir"]}/gradle/stringGenerator.gradle")
apply(from = "${rootProject.ext["buildScriptsDir"]}/gradle/applicationFileNaming.gradle")
