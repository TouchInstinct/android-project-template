object Module {

    object RoboSwag {
        const val UTILS = "utils"
        const val LOGGING = "logging"
        const val MVI_ARCH = "mvi-arch"
        const val NAVIGATION_BASE = "navigation-base"
        const val NAVIGATION_CICERONE = "navigation-cicerone"
        const val STORABLE = "storable"
        const val LIFECYCLE = "lifecycle"
        const val VIEWS = "views"
        const val RECYCLER_VIEW_ADAPTERS = "recyclerview-adapters"
        const val RECYCLER_VIEW_DECORATORS = "recyclerview-decorators"
        const val KOTLIN_EXTENSIONS = "kotlin-extensions"
    }

    object Feature {
        const val LOGIN = "feature_login"

        val ALL = listOf(
                LOGIN
        )
    }

    object Core {
        const val NETWORK = "core_network"
        const val PREFS = "core_prefs"
        const val STRINGS = "core_strings"
        const val UTILS = "core_utils"
        const val UI = "core_ui"
        const val DATA = "core_data"
        const val DOMAIN = "core_domain"
    }

}
