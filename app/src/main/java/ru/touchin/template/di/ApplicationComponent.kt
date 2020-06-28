package ru.touchin.template.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.terrakok.cicerone.Router
import ru.touchin.template.feature_login.LoginDeps
import ru.touchin.template.network.di.NetworkModule
import ru.touchin.template.App
import ru.touchin.template.SingleActivity
import ru.touchin.template.core_prefs.PreferencesModule
import ru.touchin.template.navigation.MainNavigation
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
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

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}
