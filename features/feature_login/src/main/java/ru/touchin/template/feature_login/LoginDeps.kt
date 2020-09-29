package ru.touchin.template.feature_login

import ru.touchin.template.feature_login.navigation.LoginCoordinator

interface LoginDeps {
    fun loginCoordinator(): LoginCoordinator
}
