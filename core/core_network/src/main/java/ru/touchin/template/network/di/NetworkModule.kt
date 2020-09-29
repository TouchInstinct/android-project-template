package ru.touchin.template.network.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.touchin.template.network.interceptor.ExceptionsInterceptor
import ru.touchin.template.core_network.BuildConfig
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val TIMEOUT = 30L
    }

    @Singleton
    @Provides
    fun providePublicClient(
            exceptionsInterceptor: ExceptionsInterceptor,
            @ChuckInterceptor chuckerInterceptor: Interceptor,
            @WithSslPinning withSslPinning: Boolean
    ): OkHttpClient =
            buildPublicClient(exceptionsInterceptor, chuckerInterceptor, withSslPinning)

    @Singleton
    @Provides
    fun provideMoshi() = buildMoshi()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi, @ApiUrl apiUrl: String) = buildRetrofitInstance(client, moshi, apiUrl)

    private fun buildMoshi() = Moshi.Builder()
            .build()

    private fun buildRetrofitInstance(client: OkHttpClient, moshi: Moshi, apiUrl: String): Retrofit = Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    private fun buildPublicClient(
            exceptionsInterceptor: ExceptionsInterceptor,
            chuckerInterceptor: Interceptor,
            withSslPinning: Boolean
    ): OkHttpClient = OkHttpClient.Builder()
            .apply {
                connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                readTimeout(TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                addInterceptor(exceptionsInterceptor)
                addInterceptor(chuckerInterceptor)
                if (BuildConfig.DEBUG) {
                    addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                }
                if (withSslPinning) {
                    certificatePinner(CertificatePinner.DEFAULT)
                }
            }.build()

}
