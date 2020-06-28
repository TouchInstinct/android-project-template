package ru.touchin.template.di

import android.content.Context
import dagger.Component
import ru.terrakok.cicerone.Router
import ru.touchin.mvi_test.feature_login.LoginDeps
import ru.touchin.mvitest.network.di.NetworkModule
import ru.touchin.template.App
import ru.touchin.template.SingleActivity
import ru.touchin.template.core_prefs.PreferencesModule
import ru.touchin.template.navigation.MainNavigation
import javax.inject.Singleton

@Singleton
@Component(modules = [
    PreferencesModule::class,
    MainNavigationModule::class,
    NetworkModule::class,
    CoordinatorsImpl::class
])
interface ApplicationComponent : LoginDeps {

    @MainNavigation
    fun router(): Router

    fun inject(application: App)

    fun inject(activity: SingleActivity)

}
