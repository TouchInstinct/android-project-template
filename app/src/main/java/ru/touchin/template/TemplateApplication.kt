package ru.touchin.template

import androidx.appcompat.app.AppCompatDelegate
import com.bluelinelabs.logansquare.LoganSquare
import com.touchin.vtb.di.app.ApplicationModule
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import ru.touchin.lifecycle.viewmodel.ViewModelFactory
import ru.touchin.lifecycle.viewmodel.ViewModelFactoryProvider
import ru.touchin.templates.TouchinApp
import ru.touchin.templates.logansquare.LoganSquareBigDecimalConverter
import ru.touchin.templates.logansquare.LoganSquareJodaTimeConverter
import java.math.BigDecimal
import javax.inject.Inject

class TemplateApplication : TouchinApp(), ViewModelFactoryProvider {
    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate() {
        super.onCreate()

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
