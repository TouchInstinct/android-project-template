package ru.touchin.template.core_prefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import ru.touchin.roboswag.components.utils.storables.PreferenceUtils
import ru.touchin.roboswag.core.observables.storable.NonNullStorable
import javax.inject.Singleton

@Module
class PreferencesModule {

    @Provides
    @Singleton
    fun provideDefaultSharedPreferences(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun provideTutorialStorable(sharedPreferences: SharedPreferences): NonNullStorable<String, Boolean, Boolean> = PreferenceUtils
            .booleanStorable("TUTORIAL_STORABLE", sharedPreferences, false)

}
