package ru.touchin.template.di.app.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.touchin.roboswag.components.utils.storables.PreferenceUtils
import ru.touchin.roboswag.core.observables.storable.NonNullStorable
import ru.touchin.template.di.qualifiers.SessionStorable
import ru.touchin.template.persistence.Database
import javax.inject.Singleton

@Module
class PersistentModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): Database = Room
        .databaseBuilder(context, Database::class.java, "database")
        .build()

    @Singleton
    @Provides
    @SessionStorable
    fun provideSessionStorable(sharedPreferences: SharedPreferences): NonNullStorable<String, String, String> =
        PreferenceUtils.stringStorable("MIDDLE_SESSION", sharedPreferences, "")

}
