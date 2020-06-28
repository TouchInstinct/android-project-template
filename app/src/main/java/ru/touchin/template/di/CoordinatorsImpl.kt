package ru.touchin.template.di

import dagger.Binds
import dagger.Module
import ru.touchin.template.feature_login.navigation.LoginCoordinator
import ru.touchin.template.navigation.login.LoginCoordinatorImpl

@Module
abstract class CoordinatorsImpl {

    @Binds
    abstract fun loginCoordinator(impl: LoginCoordinatorImpl): LoginCoordinator
}
