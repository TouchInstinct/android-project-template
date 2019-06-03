package ru.touchin.template.di.app

import dagger.Component
import ru.touchin.template.TemplateApplication
import ru.touchin.template.di.app.modules.ApplicationModule
import ru.touchin.template.di.app.modules.NetworkModule
import ru.touchin.template.di.app.modules.PersistentModule
import ru.touchin.template.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, PersistentModule::class, ViewModelModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(application: TemplateApplication)

}
