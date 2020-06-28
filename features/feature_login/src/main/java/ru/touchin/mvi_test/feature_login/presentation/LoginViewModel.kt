package ru.touchin.mvi_test.feature_login.presentation

import androidx.lifecycle.SavedStateHandle
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import ru.touchin.mvi_test.feature_login.navigation.LoginCoordinator
import ru.touchin.roboswag.mvi_arch.core.MviViewModel
import ru.touchin.roboswag.mvi_arch.di.ViewModelAssistedFactory
import ru.touchin.roboswag.navigation_base.fragments.EmptyState

class LoginViewModel @AssistedInject constructor(
        @Assisted arg0: SavedStateHandle,
        private val coordinator: LoginCoordinator
) : MviViewModel<EmptyState, LoginViewAction, LoginViewState>(LoginViewState, arg0) {

    override fun dispatchAction(action: LoginViewAction) {
        when (action) {
            LoginViewAction.GoToMainScreenButtonClicked -> coordinator.openMainScreen()
        }
    }

    @AssistedInject.Factory
    interface Factory : ViewModelAssistedFactory<LoginViewModel>

}
