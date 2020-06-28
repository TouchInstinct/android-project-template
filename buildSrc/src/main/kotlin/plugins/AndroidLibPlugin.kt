package plugins

import Plugins
import org.gradle.api.Project

class AndroidLibPlugin : BaseAndroidPlugin() {

    override fun apply(target: Project) {
        target.plugins.apply(Plugins.ANDROID_LIBRARY)
        super.apply(target)
    }

}
