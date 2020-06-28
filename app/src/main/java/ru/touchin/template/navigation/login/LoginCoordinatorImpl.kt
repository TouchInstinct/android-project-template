package ru.touchin.template.navigation.login

import ru.terrakok.cicerone.Router
import ru.touchin.template.feature_login.navigation.LoginCoordinator
import ru.touchin.template.navigation.MainNavigation
import javax.inject.Inject

class LoginCoordinatorImpl @Inject constructor(
        @MainNavigation private val router: Router
) : LoginCoordinator {

    override fun openMainScreen() {
        router.exit()
    }

}
