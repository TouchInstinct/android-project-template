package ru.touchin.template.navigation

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.touchin.template.feature_login.presentation.LoginFragment

object Screens {

    class Login : SupportAppScreen() {
        override fun getFragment(): Fragment = LoginFragment()

    }
}
