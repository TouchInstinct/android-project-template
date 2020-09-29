import com.android.build.gradle.BaseExtension
import java.io.File

object SigningConfig {
    const val CONFIG_NAME: String = "signing_key"
    const val PATH_TO_KEYSTORE_FILE: String = "signing_key.jks"

    const val DEFAULT_STORE_PASSWORD: String = "iphoneandroidwp7"
    const val DEFAULT_KEY_ALIAS: String = "touchin"
    const val DEFAULT_KEY_PASSWORD: String = "iphoneandroidwp7"
}

fun BaseExtension.configureSigningConfig(getRelativeFile: (String) -> File) {
    signingConfigs {
        create(SigningConfig.CONFIG_NAME) {
            storeFile = getRelativeFile(SigningConfig.PATH_TO_KEYSTORE_FILE)
            storePassword = Environment.STORE_PASSWORD.getenv() ?: SigningConfig.DEFAULT_STORE_PASSWORD
            keyAlias = Environment.KEY_ALIAS.getenv() ?: SigningConfig.DEFAULT_KEY_ALIAS
            keyPassword = Environment.KEY_PASSWORD.getenv() ?: SigningConfig.DEFAULT_KEY_PASSWORD
        }
    }

}
