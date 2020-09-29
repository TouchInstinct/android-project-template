package ru.touchin.template.feature_login.di

import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.touchin.template.feature_login.presentation.LoginViewModel
import ru.touchin.roboswag.mvi_arch.di.ViewModelAssistedFactory
import ru.touchin.roboswag.mvi_arch.di.ViewModelKey

@Module(includes = [ViewModelAssistedFactoriesModule::class])
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginByPinFactory(factory: LoginViewModel.Factory): ViewModelAssistedFactory<out ViewModel>

}

@AssistedModule
@Module(includes = [AssistedInject_ViewModelAssistedFactoriesModule::class])
abstract class ViewModelAssistedFactoriesModule
