package ru.touchin.mvi_test.feature_login.presentation

import android.os.Bundle
import android.view.View
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import ru.touchin.mvi_test.feature_login.R
import ru.touchin.mvi_test.feature_login.databinding.FragmentLoginBinding
import ru.touchin.mvi_test.feature_login.di.DaggerLoginComponent
import ru.touchin.mvi_test.feature_login.di.LoginComponent
import ru.touchin.roboswag.mvi_arch.core.MviFragment
import ru.touchin.roboswag.navigation_base.fragments.EmptyState
import ru.touchin.roboswag.navigation_base.fragments.viewBinding

class LoginFragment : MviFragment<EmptyState, LoginViewState, LoginViewAction, LoginViewModel>(R.layout.fragment_login),
        IHasComponent<LoginComponent> {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependencies()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToMainScreenButton.dispatchActionOnRippleClick(LoginViewAction.GoToMainScreenButtonClicked)
    }

    private fun injectDependencies() {
        XInjectionManager.bindComponent(this)
                .inject(this)
    }

    override fun getComponent(): LoginComponent = DaggerLoginComponent
            .factory()
            .create(XInjectionManager.findComponent())

}
