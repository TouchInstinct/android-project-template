package ru.touchin.template

import android.os.Bundle
import me.vponomarenko.injectionmanager.x.XInjectionManager
import ru.terrakok.cicerone.NavigatorHolder
import ru.touchin.roboswag.navigation_base.activities.BaseActivity
import ru.touchin.roboswag.navigation_cicerone.CiceroneTuner
import ru.touchin.template.di.ApplicationComponent
import ru.touchin.template.navigation.MainNavigation
import ru.touchin.template.navigation.StartUpNavigation
import javax.inject.Inject

class SingleActivity : BaseActivity() {

    @Inject
    @MainNavigation
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigation: StartUpNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        injectDependencies()

        lifecycle.addObserver(
                CiceroneTuner(
                        activity = this,
                        navigatorHolder = navigatorHolder,
                        fragmentContainerId = R.id.fragment_container
                )
        )

        navigation.start()
    }

    private fun injectDependencies() {
        XInjectionManager
                .findComponent<ApplicationComponent>()
                .inject(this)
    }

}
