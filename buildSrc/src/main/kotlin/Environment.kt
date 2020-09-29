object Environment {
    const val APP_ID = "BUNDLE_ID"

    const val STORE_PASSWORD = "STORE_PASSWORD"
    const val KEY_ALIAS = "KEY_ALIAS"
    const val KEY_PASSWORD = "KEY_PASSWORD"

    const val ENDPOINT = "CUSTOM_ENDPOINT"

    const val BUILD_NUMBER = "BUILD_NUMBER"
}

fun String.getenv(): String? = System.getenv(this)
