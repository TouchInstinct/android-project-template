package ru.touchin.mvi_test.feature_login

import ru.touchin.mvi_test.feature_login.navigation.LoginCoordinator

interface LoginDeps {
    fun loginCoordinator(): LoginCoordinator
}
