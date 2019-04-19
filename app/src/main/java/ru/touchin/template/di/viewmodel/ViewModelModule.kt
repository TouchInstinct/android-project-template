package ru.touchin.template.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.touchin.template.viewmodel.StartupViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StartupViewModel::class)
    fun bindStartupViewModel(viewModel: StartupViewModel): ViewModel

}
