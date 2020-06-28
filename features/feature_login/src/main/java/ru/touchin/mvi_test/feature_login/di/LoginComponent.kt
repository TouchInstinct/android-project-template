package ru.touchin.mvi_test.feature_login.di

import dagger.Component
import ru.touchin.roboswag.navigation_base.scopes.FragmentScope
import ru.touchin.mvi_test.feature_login.LoginDeps
import ru.touchin.mvi_test.feature_login.presentation.LoginFragment

@FragmentScope
@Component(modules = [ViewModelModule::class], dependencies = [LoginDeps::class])
interface LoginComponent {

    fun inject(fragment: LoginFragment)

    @Component.Factory
    interface Factory {
        fun create(deps: LoginDeps): LoginComponent
    }

}
