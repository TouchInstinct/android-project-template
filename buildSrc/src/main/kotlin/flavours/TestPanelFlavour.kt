sealed class TestPanelFlavour(
        name: String
) : Flavour(name, DIMENSION_NAME) {

    companion object {
        const val DIMENSION_NAME = "testPanel"
    }

    object OFF : TestPanelFlavour(
            name = "withoutTestPanel"
    )

    object ON : TestPanelFlavour(
            name = "withTestPanel"
    )
}
