import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer

abstract class Flavour(val flavourName: String, val dimensionName: String)

fun NamedDomainObjectContainer<ProductFlavor>.addEmptyFlavour(flavour: Flavour) {
    create(flavour.flavourName) {
        dimension = flavour.dimensionName
    }
}
