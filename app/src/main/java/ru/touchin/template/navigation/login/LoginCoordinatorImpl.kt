package ru.touchin.template.navigation.login

import ru.terrakok.cicerone.Router
import ru.touchin.mvi_test.feature_login.navigation.LoginCoordinator
import ru.touchin.template.navigation.MainNavigation
import ru.touchin.template.navigation.Screens
import javax.inject.Inject

class LoginCoordinatorImpl @Inject constructor(
        @MainNavigation private val router: Router
) : LoginCoordinator {

    override fun openMainScreen() {
        router.exit()
    }

}
