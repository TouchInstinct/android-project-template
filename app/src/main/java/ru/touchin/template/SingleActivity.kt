package ru.touchin.template

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import me.vponomarenko.injectionmanager.x.XInjectionManager
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.touchin.roboswag.navigation_base.activities.BaseActivity
import ru.touchin.roboswag.navigation_cicerone.CiceroneTuner
import ru.touchin.template.di.ApplicationComponent
import ru.touchin.template.navigation.MainNavigation
import ru.touchin.template.navigation.StartUpCoordinator
import javax.inject.Inject

// TDOD: change package name everywhere
// TODO: change google play config
class SingleActivity : BaseActivity() {

    @Inject
    @MainNavigation
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var coordinator: StartUpCoordinator

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAnalytics = Firebase.analytics

        setContentView(R.layout.activity_main)

        injectDependencies()

        lifecycle.addObserver(
                CiceroneTuner(
                        navigatorHolder = navigatorHolder,
                        navigator = SupportAppNavigator(this, R.id.fragment_container)
                )
        )

        coordinator.start()

        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                coordinator.closeCurrentScreen()
            }
        })
    }

    private fun injectDependencies() {
        XInjectionManager
                .findComponent<ApplicationComponent>()
                .inject(this)
    }

}
