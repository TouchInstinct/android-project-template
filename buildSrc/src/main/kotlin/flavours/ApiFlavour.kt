import com.android.build.gradle.BaseExtension

sealed class ApiFlavour(
        val name: String,
        val apiUrl: String
) : Flavour(name, DIMENSION_NAME) {

    companion object {
        const val DIMENSION_NAME = "apiEndpoint"
    }

    object MockDev : ApiFlavour(
            name = "mockDev",
            apiUrl = "url1"
    )

    object TouchinTest : ApiFlavour(
            name = "touchinTest",
            apiUrl = "url2"
    )

    object CustomerProd : ApiFlavour(
            name = "customerProd",
            apiUrl = "url3"
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



