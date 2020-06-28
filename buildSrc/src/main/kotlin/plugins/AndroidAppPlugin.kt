package plugins

import Plugins
import org.gradle.api.Project

class AndroidAppPlugin : BaseAndroidPlugin() {

    override fun apply(target: Project) {
        target.plugins.apply(Plugins.ANDROID_APPLICATION)
        super.apply(target)
    }

}
