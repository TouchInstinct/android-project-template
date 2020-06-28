fun includeModulesFromFolder(folderName: String) {
    file(folderName)
            .walk()
            .maxDepth(1)
            .forEach { moduleFolder ->
                include(":${moduleFolder.name}")
                project(":${moduleFolder.name}").projectDir = moduleFolder
            }
}

val roboswagModules = listOf(
        "utils",
        "logging",
        "mvi-arch",
        "pagination",
        "navigation-cicerone",
        "navigation-base",
        "storable",
        "lifecycle",
        "views",
        "recyclerview-adapters",
        "kotlin-extensions"
)

roboswagModules.forEach { module ->
    include(":$module")
    project(":$module").projectDir = file("RoboSwag/$module")
}

includeModulesFromFolder("core")
includeModulesFromFolder("features")

include(":app")
