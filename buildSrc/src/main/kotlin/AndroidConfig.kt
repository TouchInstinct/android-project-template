object AndroidConfig {
    const val COMPILE_SDK_VERSION = 29
    const val MIN_SDK_VERSION = 23
    const val TARGET_SDK_VERSION = 29
    const val BUILD_TOOLS_VERSION = "29.0.2"

    val VERSION_CODE: Int = System.getenv("BUILD_NUMBER")?.toIntOrNull() ?: 10000
    val VERSION_NAME = "1.0.0"

    val PROD_BUILD_NAME = ProguardFlavour.OBFUSCATE +
            ApiFlavour.CustomerProd.flavourName +
            SSLPinningFlavour.ON.flavourName +
            TestPanelFlavour.OFF.flavourName +
            BuildType.Release.name

    const val TEST_APP_ID = "ru.touchin.template"
    const val PROD_APP_ID = "ru.ask.client"


}



