package ru.touchin.template.navigation

import ru.terrakok.cicerone.Router
import javax.inject.Inject

class StartUpNavigation @Inject constructor(
        @MainNavigation private val router: Router
) {

    fun start() {
        router.newRootScreen(Screens.Login())
    }

}
