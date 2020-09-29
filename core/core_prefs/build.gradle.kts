plugins {
    id(Plugins.ANDROID_LIB_PLUGIN_WITH_DEFAULT_CONFIG)
}

dependencies {
    implementation(Library.DAGGER)
    implementationModule(Module.RoboSwag.STORABLE)
}
