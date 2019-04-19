package ru.touchin.template.di.app

import com.touchin.vtb.di.app.ApplicationModule
import com.touchin.vtb.di.app.PersistentModule
import ru.touchin.template.di.viewmodel.ViewModelModule
import dagger.Component
import ru.touchin.template.TemplateApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, PersistentModule::class, ViewModelModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(application: TemplateApplication)

}
