import com.android.build.gradle.LibraryExtension

sealed class SSLPinningFlavour(
        val name: String,
        val withSslPinning: Boolean
) : Flavour(name, DIMENSION_NAME) {

    companion object {
        const val DIMENSION_NAME = "sslPinning"
    }

    object OFF: SSLPinningFlavour(
            name = "withoutSSLPinning",
            withSslPinning = true
    )

    object ON: SSLPinningFlavour(
            name = "withSSLPinning",
            withSslPinning = true
    )
}

fun LibraryExtension.addFlavour(flavour: SSLPinningFlavour) {
    productFlavors {
        create(flavour.name) {
            dimension = flavour.dimensionName
            buildConfigField("Boolean", "WithSSLPinning", flavour.withSslPinning.toString())
        }
    }
}
