package ru.touchin.template.di

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.touchin.template.navigation.MainNavigation
import javax.inject.Singleton

@Module
class MainNavigationModule {

    @Provides
    @Singleton
    @MainNavigation
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @MainNavigation
    fun provideNavigatorHolder(@MainNavigation cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @MainNavigation
    fun provideRouter(@MainNavigation cicerone: Cicerone<Router>): Router = cicerone.router

}
