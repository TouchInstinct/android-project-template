package ru.touchin.template.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import ru.touchin.template.network.di.ApiUrl
import ru.touchin.template.network.di.ChuckInterceptor
import ru.touchin.template.network.di.WithSslPinning
import ru.touchin.template.BuildConfig

@Module
class ApplicationModule {

    @Provides
    @ApiUrl
    fun provideApiUrl() = BuildConfig.API_URL

    @Provides
    @WithSslPinning
    fun providePluggerForSsl() = BuildConfig.WithSSLPinning

    @Provides
    @ChuckInterceptor
    fun provideChucker(context: Context): Interceptor = ChuckerInterceptor(context)

}
