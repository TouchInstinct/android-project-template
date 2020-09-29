import com.android.build.gradle.BaseExtension

sealed class ApiFlavour(
        val name: String,
        val apiUrl: String
) : Flavour(name, DIMENSION_NAME) {

    companion object {
        const val DIMENSION_NAME = "apiEndpoint"
    }

    // TODO: change url
    object CustomerStage : ApiFlavour(
            name = "customerStage",
            apiUrl = "https://wallet-api.staging.mnxsc.tech"
    )

    // TODO: change url
    object CustomerProd : ApiFlavour(
            name = "customerProd",
            apiUrl = "https://wallet-api.prod.mnxsc.tech"
    )

}

fun BaseExtension.addFlavour(flavour: ApiFlavour, customEndpoint: String?) {
    productFlavors {
        create(flavour.name) {
            dimension = flavour.dimensionName
            buildConfigField("String", "API_URL", "\"${customEndpoint ?: flavour.apiUrl}\"")
        }
    }
}



