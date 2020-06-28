package ru.touchin.template.feature_login.presentation

import ru.touchin.roboswag.mvi_arch.marker.ViewAction

sealed class LoginViewAction : ViewAction {
    object GoToMainScreenButtonClicked : LoginViewAction()
}
