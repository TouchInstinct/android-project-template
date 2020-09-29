import com.android.build.gradle.BaseExtension

abstract class Flavour(val flavourName: String, val dimensionName: String)

fun BaseExtension.addEmptyFlavour(flavour: Flavour) {
    productFlavors {
        create(flavour.flavourName) {
            dimension = flavour.dimensionName
        }
    }
}
