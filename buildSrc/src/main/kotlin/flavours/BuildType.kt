import com.android.build.gradle.BaseExtension

fun BaseExtension.addBuildType(
        type: BuildType,
        buildScriptDir: String
) {
    buildTypes {
        getByName(type.name) {
            isMinifyEnabled = type.optimizeAndObfuscate
            isShrinkResources = type.optimizeAndObfuscate
            if (type.optimizeAndObfuscate) {
                val proguardFile = if (AndroidConfig.RELEASE_DEBUGGABLE) "noObfuscate.pro" else "obfuscate.pro"
                setProguardFiles(listOfNotNull(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "$buildScriptDir/proguard/$proguardFile",
                        "proguard/projectConfig.pro"
                ))
            }
        }
    }
}

sealed class BuildType(
        val name: String,
        val optimizeAndObfuscate: Boolean
) {

    object Debug : BuildType(
            name = "debug",
            optimizeAndObfuscate = false
    )

    object Release : BuildType(
            name = "release",
            optimizeAndObfuscate = true
    )

}



