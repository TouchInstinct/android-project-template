import com.android.build.gradle.BaseExtension

object AndroidConfig {
    const val COMPILE_SDK_VERSION = 29
    const val MIN_SDK_VERSION = 23
    const val TARGET_SDK_VERSION = 29
    const val BUILD_TOOLS_VERSION = "29.0.2"

    val VERSION_CODE: Int = Environment.BUILD_NUMBER.getenv()?.toIntOrNull() ?: 10000
    const val VERSION_NAME = "1.0.0"

    // TODO: change test package name
    const val TEST_APP_ID = "com.touchin.template"

    // TODO: change common file folder
    const val COMMON_FOLDER = "Template-common"

    const val RELEASE_DEBUGGABLE = false

}

fun BaseExtension.ignoreCustomerProdFlavourIfReleaseIsDebuggable() {
    variantFilter {
        ignore = name.contains(ApiFlavour.CustomerProd.name, ignoreCase = true) && AndroidConfig.RELEASE_DEBUGGABLE
    }
}



