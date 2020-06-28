import org.gradle.api.NamedDomainObjectContainer
import org.gradle.kotlin.dsl.NamedDomainObjectContainerScope
import java.io.File

sealed class SigningConfig(
        val name: String,
        val storeFile: File,
        val storePassword: String,
        val keyAlias: String,
        val keyPassword: String
) {
    object Test: SigningConfig(
            name = "test",
            storeFile = File("file/way"),
            storePassword = "pass",
            keyAlias = "alias",
            keyPassword = "pass"
    )

    object Prod: SigningConfig(
            name = "prod",
            storeFile = File("fsdfsd"),
            storePassword = "fsdf",
            keyAlias = "sdfdsf",
            keyPassword = "dsfsdf"
    )

}

fun NamedDomainObjectContainer<com.android.build.gradle.internal.dsl.SigningConfig>.addConfig(config: SigningConfig) {
    create(config.name) {
        storeFile = config.storeFile
        storePassword = config.storePassword
        keyAlias = config.keyAlias
        keyPassword = config.keyPassword
    }
}
