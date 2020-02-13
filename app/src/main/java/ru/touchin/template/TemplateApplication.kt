package ru.touchin.template

import androidx.appcompat.app.AppCompatDelegate
import com.bluelinelabs.logansquare.LoganSquare
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import ru.touchin.lifecycle.viewmodel.ViewModelFactory
import ru.touchin.lifecycle.viewmodel.ViewModelFactoryProvider
import ru.touchin.roboswag.components.navigation.TouchinApp
import ru.touchin.template.di.app.DaggerApplicationComponent
import ru.touchin.template.di.app.modules.ApplicationModule
import ru.touchin.templates.logansquare.LoganSquareBigDecimalConverter
import ru.touchin.templates.logansquare.LoganSquareJodaTimeConverter
import java.math.BigDecimal
import javax.inject.Inject

class TemplateApplication : TouchinApp(), ViewModelFactoryProvider {
    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate() {
        super.onCreate()
        //TODO remove after init
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        initializeLoganSquare()
        initializeDagger()

    }

    private fun initializeLoganSquare() {
        val formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ")
        LoganSquare.registerTypeConverter(BigDecimal::class.java, LoganSquareBigDecimalConverter())
        LoganSquare.registerTypeConverter(DateTime::class.java, LoganSquareJodaTimeConverter(formatter))
    }

    private fun initializeDagger() {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
            .inject(this)
    }

}
