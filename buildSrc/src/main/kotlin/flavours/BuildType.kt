import org.gradle.api.NamedDomainObjectContainer

fun NamedDomainObjectContainer<com.android.build.gradle.internal.dsl.BuildType>.addBuildType(type: BuildType) {
    getByName(type.name) {
        isMinifyEnabled = type.isMinifyEnabled
        isShrinkResources = type.isShrinkResources
    }
}

sealed class BuildType(
        val name: String,
        val isMinifyEnabled: Boolean,
        val isShrinkResources: Boolean
) {

    object Debug : BuildType(
            name = "debug",
            isMinifyEnabled = false,
            isShrinkResources = false
    )

    object Release : BuildType(
            name = "release",
            isMinifyEnabled = true,
            isShrinkResources = true
    )

}



